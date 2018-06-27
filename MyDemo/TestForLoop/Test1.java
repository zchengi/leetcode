package TestForLoop;

/**
 * break 跳出多层循环
 *
 * @author cheng
 *         2018/6/20 12:47
 */
public class Test1 {
    public static void main(String[] args) {

        loop1:
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                System.out.println("j " + j);
                if (j == 2) {
                    break loop1;
                }
            }
            System.out.println("i " + i);
        }
    }
}
