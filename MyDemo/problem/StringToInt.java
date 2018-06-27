package problem;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zhang yu
 *         2018/6/21 18:59
 */
public class StringToInt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 获取日期
        String text = scanner.nextLine();
        int[] date = new int[2];
        if (!getDate(text, date)) {
            return;
        }
        // 月份
        int m = date[0];
        // 日期
        int d = date[1];

        // 规定27个字符为3组
        HashMap<Integer, char[]> map = new HashMap<>();
        char[] chars = new char[9];
        for (int i = 0; i < 26; i++) {
            if (i > 0 && i % 9 == 0) {
                map.put(i / 9, chars);
                chars = new char[9];
            }
            chars[i % 9] = (char) ('A' + i);
        }
        chars[8] = ' ';
        map.put(3, chars);

        // 按照月份移动
        moveByMonth(m, map);
        // 按照日期移动
        moveByDay(d, map);

        // 获取输入字符
        String message = scanner.nextLine();
        char[] letter = message.toCharArray();

        // 打印对应编码
        System.out.println(charToInt(letter, map));
    }


    private static boolean getDate(String text, int[] date) {

        String[] split = text.split(" ");
        for (int i = 0; i < split.length; i++) {
            date[i] = Integer.parseInt(split[i]);
        }

        if (date[0] > 12 || date[0] < 1) {
            System.err.println("您输入的日期格式不合法，请重新输入。");
            return false;
        }

        switch (date[0]) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (date[1] < 0 || date[1] > 31) {
                    System.err.println("您输入的日期格式不合法，请重新输入。");
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (date[1] < 0 || date[1] > 30) {
                    System.err.println("您输入的日期格式不合法，请重新输入。");
                    return false;
                }
                break;
            case 2:
                // 闰年应为29天
                if (date[1] < 0 || date[1] > 28) {
                    System.err.println("您输入的日期格式不合法，请重新输入。");
                    return false;
                }
        }

        return true;
    }

    private static void moveByMonth(int m, HashMap<Integer, char[]> map) {

        for (int i = 0; i < m - 1; i++) {
            char[] tmp1 = map.get(1);
            char[] tmp2 = map.get(2);
            char[] tmp3 = map.get(3);
            map.put(1, tmp2);
            map.put(2, tmp3);
            map.put(3, tmp1);
        }
    }

    private static void moveByDay(int d, HashMap<Integer, char[]> map) {

        d = (d - 1) % map.get(1).length;
        for (int key : map.keySet()) {
            int n = d;
            char[] chars = map.get(key);
            while (n > 0) {
                for (int i = map.get(key).length - 1; i > -1; i--) {
                    char temp = chars[0];
                    chars[0] = chars[i];
                    chars[i] = temp;
                }
                n--;
            }
        }
    }

    private static String charToInt(char[] letter, HashMap<Integer, char[]> map) {

        StringBuilder sb = new StringBuilder();
        for (char c : letter) {
            for (int key : map.keySet()) {
                char[] chars = map.get(key);
                for (int i = 0; i < chars.length; i++) {
                    if (c == chars[i]) {
                        sb.append(key).append(i + 1).append(' ');
                    }
                }
            }
        }

        return sb.toString();
    }
}
