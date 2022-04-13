package main.timer;

import java.util.NoSuchElementException;

public class OneShotTimer  implements Timer {
	
	private Integer at;
	private boolean hasNext;
	
	public OneShotTimer(int at) {
		this.at = at;
		this.hasNext = true;
	}

	@Override
	public boolean hasNext() {
		return this.hasNext;
	}

	@Override
	public Integer next() {
		if (!this.hasNext) {
			throw new NoSuchElementException();
		}

		Integer next = this.at;
		this.at = null;
		this.hasNext = false;
		return next;
	}

}
