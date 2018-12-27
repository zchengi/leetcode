package _518_Coin_Change_2;

/**
 * LeetCode 518. Coin Change 2
 *
 * @author cheng
 *         2018/12/27 10:44
 */
public class Solution1 {

    public int change(int amount, int[] coins) {

        // dp[i][j] 表示 coins[i] 组成 j 的组合数
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                // 不使用 i 硬币，只使用第一个 i-1 硬币组成金额 j，共有 dp[i-1][j] 种组合
                // 使用 i 硬币（可以无限制使用相同硬币），必须满足 j - coins[i-1] > 0
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {

        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new Solution1().change(amount, coins));

        amount = 3;
        coins = new int[]{2};
        System.out.println(new Solution1().change(amount, coins));

        amount = 10;
        coins = new int[]{10};
        System.out.println(new Solution1().change(amount, coins));
    }
}
