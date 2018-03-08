package _011_Container_With_Most_Water;

/**
 * LeetCode 011. Container With Most Water
 *
 * @author cheng
 *         2018/3/8 20:48
 */
public class Solution1 {
    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // 当前 left right 的面积计算方式： Math.min(height[left], height[right]) * (right - left)
            // maxArea 取最大值
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            // 这种移动保证了 maxArea 的值永远当前遍历过的最大值
            // 而且保证了 每次移动不可能出现比移动另一位更大的面积

            // 如果右边高，则将 left 向右移动一位
            if (height[left] < height[right]) {
                left++;
            } else {
                // 如果左边高，则将 right 向右移动一位
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = {1, 2, 3, 4, 5};
        System.out.println(new Solution1().maxArea(height));
    }
}
