package _729_My_Calendar_I;


import java.util.TreeMap;

/**
 * LeetCode 729. My Calendar I
 * <p>
 * 使用 平衡二叉树
 * <p>
 * 时间复杂度：O(logn)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/25 18:50
 */
public class Solution3 {
    private static class MyCalendar {

        TreeMap<Integer, Integer> calendar;

        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {

            Integer prev = calendar.floorKey(start);
            Integer next = calendar.ceilingKey(start);
            if ((prev == null || calendar.get(prev) <= start)
                    && (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {

        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
