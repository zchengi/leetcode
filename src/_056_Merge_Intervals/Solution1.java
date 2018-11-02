package _056_Merge_Intervals;

import util.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode 056. Merge Intervals
 *
 * @author cheng
 *         2018/09/13 17:17
 */
public class Solution1 {
    public List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(i2 -> i2.start));
//        intervals.sort(Comparator.comparingInt((Interval interval) -> interval.start).reversed());

        List<Interval> res = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (end >= interval.start) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        res.add(new Interval(start, end));

        return res;
    }

    public static void main(String[] args) {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        new Solution1().merge(intervals).forEach(interval -> System.out.println(interval.start + ":" + interval.end));
    }
}
