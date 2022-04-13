package main.action;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import main.timer.Timer;

/**
 * @author flver
 *
 */
//TODO Must be refactored to be generic
public class DiscreteActionDependent implements DiscreteActionInterface {
	
	protected DiscreteAction baseAction;
	protected TreeSet<DiscreteAction> depedentActions;
	private Iterator<DiscreteAction> it;
	protected DiscreteAction currentAction;
	private Integer lapsTime;
	
	
	/**
	 * Construct a series of dependent actions, first main.test.action (method) called is baseMethodName, then method nextMethod() is called to select the next main.test.action.
	 * 
	 * @param o
	 * @param baseMethodName
	 * @param timerBase
	 */	
	public DiscreteActionDependent(Object o, String baseMethodName, Timer timerBase){
		this.baseAction = new DiscreteAction(o, baseMethodName, timerBase);
		this.depedentActions = new TreeSet<>();
		this.it = this.depedentActions.iterator();
		this.currentAction = this.baseAction;
	}
	
	public void addDependence(Object o, String depentMethodName, Timer timerDependence) {
		this.depedentActions.add(new DiscreteAction(o, depentMethodName, timerDependence));
	}

	private void reInit() {
		this.baseAction.updateTimeLaps();
		for (Iterator<DiscreteAction> iter = this.depedentActions.iterator(); iter.hasNext(); ) {
		    DiscreteAction element = iter.next();
		    element.updateTimeLaps();
		}
	}
	
	public void nextMethod(){
		if (this.currentAction == this.baseAction){
			this.it = this.depedentActions.iterator();
			this.currentAction = this.it.next();
		}else if(this.currentAction == this.depedentActions.last()){
			this.currentAction = this.baseAction;
			this.reInit();
		}else {
			this.currentAction = this.it.next();
		}
	}
	
	public void spendTime(int t) {
		for (Iterator<DiscreteAction> iter = this.depedentActions.iterator(); iter.hasNext(); ) {
		    DiscreteAction element = iter.next();
		    element.spendTime(t);
		}
	}

	public void updateTimeLaps() {
		// time laps is updated at the re-initialization
		this.currentAction.updateTimeLaps();
		this.nextMethod();	
	}

	public Method getMethod() {
		return this.currentAction.getMethod();
	}

	public Integer getCurrentLapsTime() {
		return this.currentAction.getCurrentLapsTime();
	}

	public Object getObject() {
		return this.currentAction.getObject();
	}

	public int compareTo(DiscreteActionInterface c) {
		return this.currentAction.compareTo(c);
	}

	public Boolean isEmpty() {
		return !this.hasNext();
	}

	public DiscreteActionInterface next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		return this;
	}

	public boolean hasNext() {
		return this.baseAction.hasNext() || !this.depedentActions.isEmpty();
	}

	public Integer getLapsTime() {
		return this.lapsTime;
	}

	public void setLapsTime(Integer lapsTime) {
		this.lapsTime = lapsTime;
	}

	@Override
	public void updateTimeLaps(long lapsTime) {
		// Nothing to implement
	}
}
