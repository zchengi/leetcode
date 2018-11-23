package _401_Binary_Watch;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 401. Binary Watch
 *
 * @author cheng
 *         2018/11/23 11:17
 */
public class Solution1 {

    private List<String> res = new ArrayList<>();
    private int[] hours = {1, 2, 4, 8};
    private int[] minutes = {1, 2, 4, 8, 16, 32};

    public List<String> readBinaryWatch(int num) {

        backTrack(num, 0, 0, 0);
        return res;
    }

    private void backTrack(int num, int start, int hour, int minute) {

        if (num == 0) {
            String str = String.valueOf(hour);
            if (minute < 10) {
                str = str + ":0" + String.valueOf(minute);
            } else {
                str = str + ":" + String.valueOf(minute);
            }

            if (hour < 12 && minute < 60) {
                res.add(str);
            }
        } else if (num > 0) {
            for (int i = start; i < 10; i++) {
                if (i < 6) {
                    minute += minutes[i];
                } else {
                    hour += hours[i - 6];
                }

                backTrack(num - 1, i + 1, hour, minute);
                if (i < 6) {
                    minute -= minutes[i];
                } else {
                    hour -= hours[i - 6];
                }
            }
        }
    }

    public static void main(String[] args) {

        int num = 1;
        System.out.println(new Solution1().readBinaryWatch(num));
    }
}
