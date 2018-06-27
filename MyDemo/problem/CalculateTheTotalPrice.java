package problem;

import java.util.Scanner;

/**
 * @author zhang yu
 *         2018/6/21 18:07
 */
public class CalculateTheTotalPrice {
    public static void main(String[] args) {

        // 获取键盘输入流
        Scanner scanner = new Scanner(System.in);

        // 获取预算上限
        int budget = Integer.parseInt(scanner.nextLine());
        if (budget > 10000) {
            System.err.println("输入有误，请输入小于10000的正整数。");
            return;
        }

        // 获取输入的每种物品价格
        String text = scanner.nextLine();
        // 将其转换为字符串数组
        String[] split = text.split(" ");

        // 转为整型数组
        int[] items = new int[split.length];
        for (int i = 0; i < split.length; i++) {

            items[i] = Integer.parseInt(split[i]);
            if (items[i] > 10000) {
                System.err.println("输入有误，请输入小于10000的正整数。");
                return;
            }
        }

        // 将物品数组价格按照从小到大的顺序排序
        insertionSort(items);

        // 计算总价格
        int totalPrice = 0;
        for (int price : items) {
            totalPrice += price;
            // 如果当前总价大于预算，则输出应买物品的总价格
            if (totalPrice > budget) {
                System.out.println(totalPrice - price);
                return;
            }
        }
        // 当购买的所有商品总价小于预算
        System.out.println(totalPrice);
    }

    /**
     * 插入排序
     */
    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i; j > 0 && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }
}

