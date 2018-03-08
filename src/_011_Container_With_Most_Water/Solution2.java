package _011_Container_With_Most_Water;

/**
 * LeetCode 011. Container With Most Water
 * <p>
 * 与第一版的方法大致一样，使用 while 替代 if ，性能更优，操作次数更少
 * 优化了代码，更清晰明易读
 *
 * @author cheng
 *         2018/3/8 21:09
 */
public class Solution2 {
    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int h;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, h * (right - left));

            while (left < right && height[left] <= h) {
                left++;
            }
            while (left < right && height[right] <= h) {
                right++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = {1, 2, 3, 4, 5};
        System.out.println(new Solution2().maxArea(height));
    }
}
