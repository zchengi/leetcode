package _729_My_Calendar_I;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 729. My Calendar I
 * <p>
 * 使用 ArrayList
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/25 18:38
 */
public class Solution2 {
    private static class MyCalendar {

        List<int[]> calendar;

        public MyCalendar() {
            calendar = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] iv : calendar) {
                if (iv[0] < end && start < iv[1]) return false;
            }

            calendar.add(new int[]{start, end});
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
