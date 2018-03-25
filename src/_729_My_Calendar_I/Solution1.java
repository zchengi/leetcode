package _729_My_Calendar_I;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 729. My Calendar I
 * <p>
 * 使用 Set
 * <p>
 * 分析：返回 false 的情况一种四种：
 * - start <= left && end > left && end <= right
 * - start <= left && end > right
 * - start >= left && start < end && end <= right
 * - start >= left && start < end && end >= right
 * - 总结以上四种情况就是： start < right && end > left
 *
 * @author cheng
 *         2018/3/25 18:18
 */
public class Solution1 {
    private static class MyCalendar {

        private Set<int[]> set;

        public MyCalendar() {
            set = new HashSet<>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : set) {
                if (start < arr[1] && end > arr[0]) {
                    return false;
                }
            }
            set.add(new int[]{start, end});

            return true;
        }
    }

    public static void main(String[] args) {

        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
