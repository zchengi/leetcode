package _059_Spiral_Matrix_II;

import java.util.Arrays;

/**
 * LeetCode 059. Spiral Matrix II
 *
 * @author cheng
 *         2018/4/25 12:59
 */
public class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int k = 1;
        while (k <= n * n) {

            for (int i = 0; i < n; i++) {
                int kk = toTheRight(matrix[i], k);
                if (k != kk) {
                    k = kk;
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                k = downward(matrix[i], k);
            }

            for (int i = matrix.length - 1; i >= 0; i--) {
                int kk = toTheLeft(matrix[i], k);
                if (k != kk) {
                    k = kk;
                    break;
                }
            }

            for (int i = matrix.length - 2; i >= 0; i--) {
                k = upward(matrix[i], k);
            }

        }

        return matrix;
    }

    private int downward(int[] arr, int k) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i] = k;
                return ++k;
            }
        }
        return k;
    }

    private int toTheLeft(int[] arr, int k) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i] = k++;
            }
        }
        return k;
    }

    private int upward(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = k;
                return ++k;
            }
        }
        return k;
    }

    private int toTheRight(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = k++;
            }
        }

        return k;
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = new Solution().generateMatrix(n);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
