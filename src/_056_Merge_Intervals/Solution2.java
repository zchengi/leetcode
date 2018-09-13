package _056_Merge_Intervals;

import util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 056. Merge Intervals
 *
 * @author cheng
 *         2018/09/13 17:44
 */
public class Solution2 {
    public List<Interval> merge(List<Interval> intervals) {

        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        List<Interval> res = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        new Solution2().merge(intervals).forEach(interval -> System.out.println(interval.start + ":" + interval.end));
    }
}
