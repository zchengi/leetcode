package _322_Coin_Change;

/**
 * LeetCode 322. Coin Change
 * <p>
 * 记忆化搜素
 *
 * @author cheng
 *         2018/12/22 14:58
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }

        return dfs(coins, amount, new int[amount + 1]);
    }

    private int dfs(int[] coins, int amount, int[] coinCount) {

        // 不能凑成
        if (amount < 0) return -1;

        // 能凑成
        if (amount == 0) return 0;

        if (coinCount[amount] != 0) {
            // 返回当前 amount 能凑成的最少硬币数
            return coinCount[amount];
        }

        // 计算能凑成当前 amount 的最少硬币数
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, coinCount);
            if (res >= 0 && res < min - 1) {
                min = 1 + res;
            }
        }

        coinCount[amount] = (min == Integer.MAX_VALUE) ? -1 : min;

        return coinCount[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution1().coinChange(coins, amount));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(new Solution1().coinChange(coins2, amount2));
    }
}
