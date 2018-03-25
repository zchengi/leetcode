package _731_My_Calendar_II;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 731. My Calendar II
 * <p>
 * 暴力解法
 * 分析： calendar 记录每一对时间， overlaps 记录所有重复的时间，如果当前时间对包含 overlap，则证明三个时间对有交集；
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/25 19:08
 */
public class Solution1 {
    private static class MyCalendarTwo {

        List<int[]> calendar;
        List<int[]> overlaps;

        public MyCalendarTwo() {
            calendar = new ArrayList<>();
            overlaps = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] iv : overlaps) {
                if (iv[0] < end && start < iv[1]) {
                    return false;
                }
            }

            for (int[] iv : calendar) {
                if (iv[0] < end && start < iv[1]) {
                    overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
                }
            }

            calendar.add(new int[]{start, end});
            return true;
        }
    }

    public static void main(String[] args) {

        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }
}
