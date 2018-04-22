package Shuffle_Algorithm;

/**
 * 洗牌算法实验
 * <p>
 * 第一种：洗牌结果不够乱，得到的结果是有偏的
 * <p>
 * 并不能保证等概率的生成结果之一，也就是并不能保证每一个位置最终有雷的概率的一半一半的
 *
 * @author cheng
 *         2018/4/22 12:49
 */
public class ShuffleExp1 {

    /**
     * 模拟次数
     */
    private int N;
    /**
     * 格子总数
     */
    private int n;
    /**
     * 雷的总数
     */
    private int m;

    public ShuffleExp1(int N, int n, int m) {

        if (N <= 0) {
            throw new IllegalArgumentException("N must be larger than 0!");
        }
        if (n < m) {
            throw new IllegalArgumentException("n must be larger than or equals to m!");
        }


        this.N = N;
        this.n = n;
        this.m = m;
    }

    /**
     * 算法逻辑
     */
    public void run() {

        // 记录出现雷的次数
        int[] freq = new int[n];

        // 在大小为 n 的数组内模拟
        int[] arr = new int[n];

        for (int i = 0; i < N; i++) {

            // 1.数组重新赋值
            reset(arr);
            // 2.洗牌算法
            shuffle(arr);

            // 3.记录有雷的次数
            for (int j = 0; j < n; j++) {
                freq[j] += arr[j];
            }
        }

        // 打印每个位置出现过雷的概率
        for (int i = 0; i < n; i++) {
            System.out.println(i + " : " + (double) freq[i] / N);
        }
    }

    private void reset(int[] arr) {
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }

        for (int i = m; i < n; i++) {
            arr[i] = 0;
        }
    }

    private void shuffle(int[] arr) {

        for (int i = 0; i < n; i++) {
            int x = (int) (Math.random() * n);
            swap(arr, i, x);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int N = 10000000;
        int n = 10;
        int m = 5;

        ShuffleExp1 exp = new ShuffleExp1(N, n, m);
        exp.run();
    }
}
