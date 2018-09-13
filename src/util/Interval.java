package util;

/**
 * Definition for an interval
 *
 * @author cheng
 *         2018/09/13 17:17
 */
public class Interval {

    public int start;
    public int end;

    public Interval() {
        this(0, 0);
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
