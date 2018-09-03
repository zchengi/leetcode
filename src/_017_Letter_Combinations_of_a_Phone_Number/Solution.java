package _017_Letter_Combinations_of_a_Phone_Number;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 017. Letter Combinations of a Phone Number
 *
 * @author cheng
 *         2018/09/03 11:23
 */
public class Solution {

    public List<String> letterCombinations(String digits) {

        LinkedList<String> res = new LinkedList<>();

        if (digits.isEmpty()) {
            return res;
        }
        res.add("");
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        while (res.peek().length() != digits.length()) {
            String remove = res.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                res.addLast(remove + c);
            }
        }

        return res;
    }


    public static void main(String[] args) {

        String digits = "23";
        System.out.println(new Solution().letterCombinations(digits));
    }
}
