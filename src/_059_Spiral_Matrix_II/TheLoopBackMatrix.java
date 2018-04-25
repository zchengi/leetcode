package _059_Spiral_Matrix_II;

import java.util.Arrays;

/**
 * 这道题是从右上开始遍历的，跟 LeetCode 059相似
 * <p>
 * <p>
 * 在 n*m 矩阵里，从右顶角的位置绕圈填入数字，直到矩阵全部填满数字位置。
 * 数字从1递增。
 * <p>
 * 如： n = 3 ， m = 4 ，矩阵输出如下：
 * [[ 8, 9,  10, 1 ],
 * [ 7, 12, 11, 2 ],
 * [ 6, 5,  4,  3 ]]
 *
 * @author cheng
 *         2018/4/25 11:34
 */
public class TheLoopBackMatrix {


    public int[][] generateMatrix(int n, int m) {

        int[][] matrix = new int[n][m];

        int k = 1;
        while (k <= n * m) {
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

            for (int i = 0; i < n; i++) {
                int kk = toTheRight(matrix[i], k);
                if (k != kk) {
                    k = kk;
                    break;
                }
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
        int n = 7, m = 7;
        int[][] matrix = new TheLoopBackMatrix().generateMatrix(n, m);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
