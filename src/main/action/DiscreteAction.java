package main.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.timer.Timer;

import javax.swing.*;

/**
 * @author Tiphaine Bulou (2016)
 * @author Flavien Vernier
 *
 */

public class DiscreteAction implements DiscreteActionInterface, Action {
	private Object object;
	private Method method;

	
	private Timer timer;				// main.test.timer provides new lapsTime
	//private TreeSet<Integer> dates;	// obsolete, managed in main.test.timer
	//private Vector<Integer> lapsTimes;// obsolete, managed in main.test.timer
	private Integer lapsTime; 			// waiting time (null if never used)
	
	private Logger logger;

	// Constructor
	
	private DiscreteAction() {
		// Start logger
			this.logger = Logger.getLogger("DAS");
			this.logger.setLevel(Level.ALL);
			this.logger.setUseParentHandlers(true);
	}
	
	public DiscreteAction(Object o, String m, Timer timer){
		this();
		this.object = o;
		try{
			this.method = o.getClass().getDeclaredMethod(m);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.timer = timer;
	}
	
	// ATTRIBUTION

	public void spendTime(int t) {
		Integer old = this.lapsTime;
		if(this.lapsTime != null) {
			this.lapsTime -= t;
		}
		String log = String.format("[DA] operate spendTime on  %s:%s: old time %s new time %s", this.getObject().getClass().getName(), this.getObject().hashCode(), old, this.getCurrentLapsTime());
		this.logger.log(Level.FINE, log);
	}

	// RECUPERATION

	public Method getMethod(){
		return method;
	}
	public Integer getCurrentLapsTime(){
		return lapsTime;
	}
	public Object getObject(){
		return object;
	}



	// COMPARAISON
	public int compareTo(DiscreteActionInterface c) {
		if (this.lapsTime == null) { // no lapstime is equivalent to infinity 
			return 1;
		}
		if (c.getCurrentLapsTime() == null) {// no lapstime is equivalent to infinity 
			return -1;
		}
    	if(this.lapsTime > c.getCurrentLapsTime()){
    		return 1;
    	}
    	if(this.lapsTime < c.getCurrentLapsTime()){
    		return -1;
    	}
		if(this.lapsTime.equals(c.getCurrentLapsTime())){
			return 0;
		}
		return 0;
	}

	public String toString(){
		return "Object : " + this.object.getClass().getName() + "\n Method : " + this.method.getName()+"\n Stat. : "+ this.timer + "\n delay: " + this.lapsTime;

	}

	public DiscreteActionInterface next() {
		Integer old = this.lapsTime;
		this.lapsTime = this.timer.next();

		String log = String.format("[DA] operate next on  %s:%s: old time %s new time %s", this.getObject().getClass().getName(), this.getObject().hashCode(), old, this.getCurrentLapsTime());
		this.logger.log(Level.FINE, log);
		return this;
	}

	public boolean hasNext() {
		return this.timer != null && this.timer.hasNext();
	}


	@Override
	public Object getValue(String key) {
		return this.object;
	}

	@Override
	public void putValue(String key, Object value) {
		this.object = value;
	}

	@Override
	public void setEnabled(boolean b) {
		if (this.hasNext()) {
			this.timer.next();
		}
	}

	@Override
	public boolean isEnabled() {
		return this.hasNext();
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// Nothing to implement
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// Nothing to implement
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Nothing to implement
	}

	public void updateTimeLaps() {
		if (this.hasNext()) {
			this.next();
		}
	}

	@Override
	public void updateTimeLaps(long lapsTime) {
		// Nothing to implement
	}

	public Integer getLapsTime() {
		return this.lapsTime;
	}

	public void setLapsTime(Integer lapsTime) {
		this.lapsTime = lapsTime;
	}
}
