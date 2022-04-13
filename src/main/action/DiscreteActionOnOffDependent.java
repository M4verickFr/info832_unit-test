package main.action;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.SortedSet;

import main.timer.DateTimer;
import main.timer.Timer;

/**
 * @author flver
 *
 */
public class DiscreteActionOnOffDependent implements DiscreteActionInterface {
	
	protected DiscreteActionInterface onAction;
	protected DiscreteActionInterface offAction;
	protected DiscreteActionInterface currentAction;
	
	private Integer lastOffDelay=0;

	private Integer lapsTime;
	
	/**
	 * Construct an On Off dependence, first main.test.action (method) called is On, then method nextMethod() is called to select the next main.test.action.
	 * The default behavior of nextMethod() is to switch between On and Off actions.  It can be change by overloading. 
	 * 
	 * @param o
	 * @param on
	 * @param timerOn
	 * @param off
	 * @param timerOff
	 */
	
	public DiscreteActionOnOffDependent(Object o, String on, Timer timerOn, String off, Timer timerOff){
		this.onAction = new DiscreteAction(o, on, timerOn);
		this.offAction = new DiscreteAction(o, off, timerOff);
		
		this.currentAction = this.offAction;
	}
	
	public DiscreteActionOnOffDependent(Object o, String on, SortedSet<Integer> datesOn, String off, SortedSet<Integer> datesOff){
		this.onAction = new DiscreteAction(o, on, new DateTimer(datesOn));
		this.offAction = new DiscreteAction(o, off, new DateTimer(datesOff));

		if(datesOn.first() < datesOff.first()){
			this.currentAction = this.onAction;
		}else{
			this.currentAction = this.offAction;
		}
	}

	public void nextAction(){
		if (this.currentAction == this.onAction){
			this.currentAction = this.offAction;
			this.currentAction = this.currentAction.next();
			this.lastOffDelay = this.currentAction.getCurrentLapsTime();
		}else{
			this.currentAction = this.onAction;
			this.currentAction = this.currentAction.next();
			this.currentAction.spendTime(this.lastOffDelay);
		}
	}

	public	void spendTime(int t) {
		this.currentAction.spendTime(t);
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
	
	public DiscreteActionInterface next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}

		this.nextAction();
		return this;
	}
	
	public boolean hasNext() {
		return this.onAction.hasNext() || this.offAction.hasNext();		
	}

	public Integer getLapsTime() {
		return this.lapsTime;
	}

	public void setLapsTime(Integer lapsTime) {
		this.lapsTime = lapsTime;
	}

	@Override
	public void updateTimeLaps() {
		// Nothing to implement
	}

	@Override
	public void updateTimeLaps(long lapsTime) {
		// Nothing to implement
	}

}
