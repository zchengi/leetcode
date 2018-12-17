package _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

/**
 * LeetCode 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * @author cheng
 *         2018/12/9 11:20
 */
public class Solution1 {
    public int maxProfit(int[] prices) {

        int sell = 0;
        int prev_sell = 0;
        int buy = Integer.MIN_VALUE;
        int prev_buy;

        for (int price : prices) {

            // 优化 cooldown 过程
            prev_buy = buy;
            // 当天 buy 的最大利润 = (前一天出售 - 当天的购买价格) 与 (当天 buy 的最大值)
            buy = Math.max(prev_sell - price, prev_buy);

            // 优化 cooldown 过程
            prev_sell = sell;
            // 当天 sell 的最大利润 = (前一天购买 + 当天的出售价格) 与 (当天 sell 的最大值)
            sell = Math.max(prev_buy + price, prev_sell);
        }

        return sell;
    }

    public static void main(String[] args) {

        int[] price = {1, 2, 3, 0, 2};
        System.out.println(new Solution1().maxProfit(price));
    }
}
