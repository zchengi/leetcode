package _401_Binary_Watch;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 401. Binary Watch
 *
 * @author cheng
 *         2018/11/23 11:27
 */
public class Solution2 {

    public List<String> readBinaryWatch(int num) {

        List<String> times = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return times;
    }

    public static void main(String[] args) {

        int num = 1;
        System.out.println(new Solution2().readBinaryWatch(num));
    }
}
