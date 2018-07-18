package _007_Sort_Time;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author cheng
 *         2018/7/10 13:10
 */
public class test {

    private static void test1(Integer[] nums) {
        long start = System.currentTimeMillis();
        Arrays.sort(nums, (i1, i2) -> i2 - i1);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(nums));
    }

    private static void test2(Integer[] nums) {
        long start = System.currentTimeMillis();
        Arrays.sort(nums);
        Collections.reverse(Arrays.asList(nums));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        Integer[] nums = {15, 20, 9, 6};
        Integer[] nums2 = {15, 20, 9, 6};
        test1(nums);
        test2(nums2);
    }
}
