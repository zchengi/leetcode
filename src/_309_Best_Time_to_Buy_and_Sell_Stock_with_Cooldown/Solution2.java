package _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

/**
 * LeetCode 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * @author cheng
 *         2018/12/17 14:40
 */
public class Solution2 {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // 记录最大利润
        int buy = Integer.MIN_VALUE;
        int prev_buy;
        int sell = 0;
        int prev_sell = 0;

        for (int price : prices) {

            prev_buy = buy;
            // 今天买或者不买
            buy = Math.max(prev_sell - price, prev_buy);

            prev_sell = sell;
            // 今天卖或者不卖
            sell = Math.max(prev_buy + price, prev_sell);
        }

        return sell;
    }

    public static void main(String[] args) {

        int[] price = {1, 2, 3, 0, 2};
        System.out.println(new Solution2().maxProfit(price));
    }
}
