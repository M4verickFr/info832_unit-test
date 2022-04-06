package timer;


public class PeriodicTimer implements Timer {

    /**
     * Integer used for the period of the {@link PeriodicTimer}
     */
    private int period;

    /**
     * Integer used as the next return value of the {@link PeriodicTimer}
     */
    private int next;

    /**
     * {@link RandomTimer} used to have a next value more or less an other value
     */
    private RandomTimer moreOrLess = null;

    /**
     * <p>Create a {@link PeriodicTimer} with both the same value for the period and the next value</p>
     *
     * @param at used to be both the period and the next value
     */
    public PeriodicTimer(int at) {
        this.period = at;
        this.next = at;
    }

    /**
     * @param at The period of the {@link PeriodicTimer}
     * @param moreOrLess use MergedTimer instead
     * @deprecated because the can use {@link MergedTimer} which is better
     */
    @Deprecated
    public PeriodicTimer(int at, RandomTimer moreOrLess) {
        this.period = at;
        this.moreOrLess = moreOrLess;
        this.next = at + (int) (this.moreOrLess.next() - this.moreOrLess.getMean());
    }

    /**
     * <p>Create a {@link PeriodicTimer} with a given period and a next value</p>
     *
     * @param period The period of the {@link PeriodicTimer} which is the same next value after the first next call
     * @param at The first next value
     */
    public PeriodicTimer(int period, int at) {
        this.period = period;
        this.next = at;
    }

    /**
     * @param period The period of the {@link PeriodicTimer}
     * @param at The first next value
     * @param moreOrLess use MergedTimer instead
     * @deprecated because the can use {@link MergedTimer} which is better
     */
    @Deprecated
    public PeriodicTimer(int period, int at, RandomTimer moreOrLess) {
        this.period = period;
        this.moreOrLess = moreOrLess;
        this.next = at + (int) (this.moreOrLess.next() - this.moreOrLess.getMean());
    }

    /**
     * <p>Returns the period of the {@link PeriodicTimer}</p>
     *
     * @return the period of this Timer
     */
    public int getPeriod() {
        return this.period;
    }

    /**
     * <p>Returns the value of the {@link PeriodicTimer}</p>
     *
     * @return the next value of the Timer
     */
    @Override
    public Integer next() {

        int previousNext = this.next;

        if (this.moreOrLess != null) {

            // This has no sense
            this.next = this.period + (int) (this.moreOrLess.next() - this.moreOrLess.getMean());
        } else {
            this.next = this.period;
        }

        return previousNext;
    }

    /**
     * <p>Know if the Timer has a next value</p>
     *
     * @return always true as this Timer is a {@link PeriodicTimer}
     */
    @Override
    public boolean hasNext() {
        return true;
    }
}