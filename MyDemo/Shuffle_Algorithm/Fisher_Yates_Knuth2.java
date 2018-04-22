package Shuffle_Algorithm;

/**
 * Fisher-Yates-Knuth 洗牌算法
 * <p>
 * 随机性很强
 * 另一种实现：从后向前的寻找随机数
 *
 * @author cheng
 *         2018/4/22 13:15
 */
public class Fisher_Yates_Knuth2 {

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

    public Fisher_Yates_Knuth2(int N, int n, int m) {

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

        for (int i = n - 1; i >= 0; i--) {
            // 从 [0, i + 1) 区间里随机选择元素
            int x = (int) (Math.random() * (i + 1));
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

        Fisher_Yates_Knuth2 exp = new Fisher_Yates_Knuth2(N, n, m);
        exp.run();
    }

}
