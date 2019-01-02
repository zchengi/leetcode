package _070_Climbing_Stairs;

/**
 * LeetCode 070. Climbing Stairs
 * <p>
 * 对于第n个斐波那契数, 可以推导出其公式
 * Fn = 1/sqrt(5) * {[(1+sqrt(5))/2]^n - [(1-sqrt(5))/2]^n}
 * 注意: 这个方法的时间复杂度依然是 O(logn) 的,因为数的幂运算也需要 logn 的时间
 * 但这个方法快于使用矩阵的幂运算符的方法
 * <p>
 * 时间复杂度: O(logn)
 * 空间复杂度: O(1)
 *
 * @author cheng
 *         2019/1/2 15:27
 */
public class Solution6 {
    public int climbStairs(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than zero");
        }

        if (n == 1) {
            return 1;
        }

        double sqrt5 = Math.sqrt(5.0);
        return (int) ((Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1)) / sqrt5);
    }

    public static void main(String[] args) {

        int n = 10;
        System.out.println((new Solution3()).climbStairs(n));
    }
}
