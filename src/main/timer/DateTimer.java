package main.timer;


import java.util.*;



public class DateTimer implements Timer {

	private ArrayList<Integer> lapsTimes;
	private Iterator<Integer> iterator;

	public DateTimer(Set<Integer> dates) {
		this.lapsTimes = new ArrayList<>();
		Integer last;
		Integer current = 0;

		for (Integer date : dates) {
			last = current;
			current = date;
			this.lapsTimes.add(current - last);
		}
		this.iterator = this.lapsTimes.iterator();
	}


	public DateTimer(List<Integer> lapsTimes) {
		this.lapsTimes = new ArrayList<>(lapsTimes);
		this.iterator = this.lapsTimes.iterator();
	}



	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}


	@Override
	public Integer next() {
		return iterator.next();
	}
}