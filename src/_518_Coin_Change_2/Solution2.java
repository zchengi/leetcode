package _518_Coin_Change_2;

/**
 * LeetCode 518. Coin Change 2
 *
 * @author cheng
 *         2018/12/27 10:56
 */
public class Solution2 {

    public int change(int amount, int[] coins) {

        // dp[i] 表示 amount 为 i 时的组合数
        // dp[i] = dp[i - coins[0]] + dp[i - coins[1]] + ... + dp[i - coins[coins.length - 1]] if i - coins[0] >= 0
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new Solution2().change(amount, coins));

        amount = 3;
        coins = new int[]{2};
        System.out.println(new Solution2().change(amount, coins));

        amount = 10;
        coins = new int[]{10};
        System.out.println(new Solution2().change(amount, coins));
    }
}
