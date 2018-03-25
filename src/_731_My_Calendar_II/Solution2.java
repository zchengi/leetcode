package _731_My_Calendar_II;


import java.util.TreeMap;

/**
 * LeetCode 731. My Calendar II
 * <p>
 * 边界计数
 * <p>
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 *
 * @author cheng
 *         2018/3/25 19:19
 */
public class Solution2 {
    private static class MyCalendarTwo {

        TreeMap<Integer, Integer> delta;

        public MyCalendarTwo() {
            delta = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            delta.put(start, delta.getOrDefault(start, 0) + 1);
            delta.put(end, delta.getOrDefault(end, 0) - 1);

            int active = 0;
            for (int d : delta.values()) {
                active += d;
                if (active >= 3) {
                    delta.put(start, delta.get(start) - 1);
                    delta.put(end, delta.get(end) + 1);
                    if (delta.get(start) == 0) {
                        delta.remove(start);
                    }
                    return false;
                }
            }

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
