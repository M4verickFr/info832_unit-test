package main.timer;

import java.util.Iterator;

public interface Timer extends Iterator<Integer>{
	/*
	 * return the delay time
	 * @see java.util.Iterator#next()
	 */
	public Integer next();
}
