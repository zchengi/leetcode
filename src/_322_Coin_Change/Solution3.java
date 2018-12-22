package _322_Coin_Change;

import java.util.Arrays;

/**
 * LeetCode 322. Coin Change
 *
 * @author cheng
 *         2018/12/22 16:01
 */
public class Solution3 {

    private int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void helper(int[] coins, int amount, int index, int cur) {

        if (index < 0) {
            return;
        }

        if (amount % coins[index] == 0) {
            min = Math.min(min, cur + amount / coins[index]);
            return;
        }

        for (int i = amount / coins[index]; i >= 0; i--) {
            if (cur + i >= min) {
                break;
            }

            helper(coins, amount - i * coins[index], index - 1, cur + i);
        }
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution3().coinChange(coins, amount));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(new Solution3().coinChange(coins2, amount2));
    }
}
