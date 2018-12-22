package _322_Coin_Change;

/**
 * LeetCode 322. Coin Change
 *
 * @author cheng
 *         2018/12/22 15:46
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }

        int[] memo = new int[amount + 1];
        int curAmount = 0;

        while (++curAmount <= amount) {
            int min = -1;
            // 计算当前 amount 的最少凑成次数
            for (int coin : coins) {
                if (curAmount >= coin && memo[curAmount - coin] != -1) {
                    int tempMin = 1 + memo[curAmount - coin];
                    if (min == -1) {
                        min = tempMin;
                    } else {
                        min = tempMin < min ? tempMin : min;
                    }
                }
            }

            memo[curAmount] = min;
        }

        return memo[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution2().coinChange(coins, amount));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(new Solution2().coinChange(coins2, amount2));
    }
}
