package _093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 093. Restore IP Addresses
 *
 * @author cheng
 *         2018/11/7 11:48
 */
public class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        restoreIpByDFS(s, 0, "", 0);
        return res;
    }

    private void restoreIpByDFS(String ip, int index, String restored, int count) {

        if (count > 4) {
            return;
        }

        if (count == 4 && index == ip.length()) {
            res.add(restored);
        }

        for (int i = 1; i < 4; i++) {
            if (index + i > ip.length()) {
                break;
            }

            String str = ip.substring(index, index + i);

            // 从 0开始并且 str 长度大于一 或者 数字个数等于 3 并且该数字大于 256
            boolean flag = (str.startsWith("0") && i > 1) || (i == 3 && Integer.parseInt(str) > 255);
            if (flag) {
                continue;
            }

            restoreIpByDFS(ip, index + i, restored + str + (count == 3 ? "" : "."), count + 1);

        }
    }

    public static void main(String[] args) {

        String s = "25525511135";
        System.out.println(new Solution().restoreIpAddresses(s));
    }
}
