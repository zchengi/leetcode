package num;

/**
 * 按照最高位输出每一位数字
 *
 * @author cheng
 *         2018/4/4 16:22
 */
public class NumberOfDigits {
    public static void print(int num) {

        for (int i = 10; i < num * 10; i *= 10) {
            int j = num;
            while (j > i) {
                j /= 10;
            }
            System.out.println(j % 10);
        }
    }

    public static void main(String[] args) {
        int num = 1234567;
        NumberOfDigits.print(num);
    }
}
