package main.action;

import java.lang.reflect.Method;
import java.util.Iterator;

public interface DiscreteActionInterface extends Comparable<DiscreteActionInterface>, Iterator<DiscreteActionInterface> {

	/*
	 * decrease the time of discrete main.test.action
	 */
	public	void spendTime(int t);
	
	/*
	 * return the method to execute
	 */
	public Method getMethod();
	
	/*
	 * return the last laps time without update
	 */
	public Integer getCurrentLapsTime();
	
	/*
	 * get the object on which the method must be invoked
	 */
	public Object getObject();

	// COMPARAISON
	/*
	 * compare discrete main.test.action according to the time before execution
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(DiscreteActionInterface c);
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public DiscreteActionInterface next();
	
	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext();

	public Integer getLapsTime();

	public void setLapsTime(Integer lapsTime);

	public void updateTimeLaps();

	public void updateTimeLaps(long lapsTime);
}
