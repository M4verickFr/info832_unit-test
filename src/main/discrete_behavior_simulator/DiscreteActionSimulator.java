
package main.discrete_behavior_simulator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.action.DiscreteActionInterface;


/**
 * @author Tiphaine Bulou (2016)
 * @author Flavien Vernier
 *
 */
public class DiscreteActionSimulator implements Runnable {


	private Thread t;
	private boolean running = false;
	
	private Clock globalTime;
	
	private ArrayList<DiscreteActionInterface> actionsList = new ArrayList<>();
	
	private int nbLoop;
	private int step;
	
	private Logger logger;
	private FileHandler logFile; 
	private ConsoleHandler logConsole; 

	public DiscreteActionSimulator(){
		
		// Start logger
		this.logger = Logger.getLogger("DAS");
		this.logger.setLevel(Level.ALL);
		this.logger.setUseParentHandlers(true);
		try{
			this.logFile = new FileHandler(this.getClass().getName() + ".log");
			this.logFile.setFormatter(new LogFormatter());
			this.logConsole = new ConsoleHandler();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.logger.addHandler(logFile);
		this.logger.addHandler(logConsole);
		

		this.globalTime = Clock.getInstance();
		
		this.t = new Thread(this);
		this.t.setName("Discrete Action Simulator");
	}
	
	/**
	 * @param nbLoop defines the number of loop for the simulation, the simulation is infinite if nbLoop is negative or 0.
	 */
	public void setNbLoop(int nbLoop){
		if(nbLoop>0){
			this.nbLoop = nbLoop;
			this.step = 1;
		}else{ // running infinitely
			this.nbLoop = 0;
			this.step = -1;
		}
	}
	
	public void addAction(DiscreteActionInterface c){

		if(c.hasNext()) {
			// add to list of actions, next is call to the main.test.action exist at the first time
			this.actionsList.add(c.next());

			// sort the list for ordered execution 
			Collections.sort(this.actionsList);
		}
	}

	/**
	 * @return the laps time before the next main.test.action
	 */
	private int nextLapsTime() {
		DiscreteActionInterface currentAction = this.actionsList.get(0);
		return currentAction.getCurrentLapsTime();
	}
	/**
	 * @return laps time of the running main.test.action
	 */
	private int runAction(){
		// Run the first main.test.action

		DiscreteActionInterface currentAction = this.actionsList.get(0);
		Object o = currentAction.getObject();
		Method m = currentAction.getMethod();
		int sleepTime = currentAction.getCurrentLapsTime();
		
		try {
			Thread.sleep(sleepTime); // Real time can be very slow
			Thread.yield();
			if(this.globalTime!=null) {
				this.globalTime.increase(sleepTime);
			}
			m.invoke(o);
			if(this.globalTime!=null) {
				String log = String.format("[DAS] run main.test.action %s on %s:%s at %s after %s time units", m.getName(), o.getClass().getName(), o.hashCode(), this.globalTime.getTime(), sleepTime);
				this.logger.log(Level.FINE, log);
			}else {
				String log = String.format("[DAS] run main.test.action %s on %s:%s after %s time units", m.getName(), o.getClass().getName(), o.hashCode(), sleepTime);
				this.logger.log(Level.FINE, log);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

		return sleepTime;
	}

	private void updateTimes(int runningTimeOf1stCapsul){
		
		// update time laps off all actions
		for(int i=1 ; i < this.actionsList.size(); i++){
			int d = this.actionsList.get(i).getLapsTime();
			this.actionsList.get(i).setLapsTime(d- runningTimeOf1stCapsul);
			this.actionsList.get(i).spendTime(runningTimeOf1stCapsul);
		}

		// get new time lapse of first main.test.action
		if(this.globalTime == null) {
			this.actionsList.get(0).updateTimeLaps();
		}else {	
			this.actionsList.get(0).updateTimeLaps(this.globalTime.getTime());
		}
		
		// remove the main.test.action if no more lapse time is defined
		if(this.actionsList.get(0).getLapsTime() == null) {
			this.actionsList.remove(0);
		}else {
			// resort the list
			Collections.sort(this.actionsList);
		}

		DiscreteActionInterface a = this.actionsList.remove(0);
		if(a.hasNext()) {
			a = a.next();
			this.actionsList.add(a);
			if(this.globalTime!=null) {
				String log = String.format("[DAS] reset main.test.action %s on %s:%s at %s to %s time units", a.getMethod().getName(), a.getObject().getClass().getName(), a.getObject().hashCode(), this.globalTime.getTime(), a.getCurrentLapsTime());
				this.logger.log(Level.FINE, log);
			}else {
				String log = String.format("[DAS] reset main.test.action %s on %s:%s to %s time units", a.getMethod().getName(), a.getObject().getClass().getName(), a.getObject().hashCode(), a.getCurrentLapsTime());
				this.logger.log(Level.FINE, log);
			}
			Collections.sort(this.actionsList);
		}
	}


	public void run() {
		int count = this.nbLoop;
		boolean finished = false;

		String log = String.format("LANCEMENT DU THREAD %s", t.getName());
		this.logger.log(Level.FINE, log);

		while(running && !finished){

			if(!this.actionsList.isEmpty()){
				log = this.toString();
				this.logger.log(Level.FINE, log);
				this.globalTime.setNextJump(this.nextLapsTime());
				
				this.globalTime.lockWriteAccess();
				int runningTime = this.runAction();
				this.updateTimes(runningTime);
				this.globalTime.unlockWriteAccess();
				try {
					Thread.sleep(100);
					this.globalTime.increase(100);
				}catch(Exception e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}else{
				this.logger.log(Level.FINE, "NOTHING TO DO\n");
				this.stop();
			}

			count -= this.step;
			if(count<=0) {
				finished = true;
			}
		}
		this.running = false;
		if(this.step>0) {
			log = String.format("DAS: %s actions done for %s turns asked.", this.nbLoop - count, this.nbLoop);
			this.logger.log(Level.FINE, log);
		}else {
			log = String.format("DAS: %s actions done!", count);
			this.logger.log(Level.FINE, log);
		}
	}

	public void start(){
		this.running = true;
		this.t.start();
	}

	public void stop(){
		String log = String.format("STOP THREAD %s obj %s", t.getName(), this);
		this.logger.log(Level.FINE, log);
		this.running = false;
	}
	
	public String toString(){
		StringBuilder toS = new StringBuilder("------------------\nTestAuto :" + this.actionsList.size());
		for(DiscreteActionInterface c : this.actionsList){
			toS.append(c.toString()).append("\n");
		}
		toS.append("---------------------\n");
		return toS.toString();
	}

	public boolean getRunning() {
		return this.running;
	}

}
