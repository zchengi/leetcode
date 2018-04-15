package Eight_Queens;


/**
 * DFS 求解八皇后问题
 * <p>
 * 找出所有解(使用二维布尔型数组)
 *
 * @author cheng
 *         2018/4/15 16:40
 */
public class Solution3 {

    /**
     * 棋盘格子范围，同时也是皇后个数
     */
    private static final int MAX_NUM = 8;
    /**
     * 八皇后问题解法计数
     */
    private static int count = 0;


    public void findEightQueen(boolean[][] chessboard, int row) {

        // 递归终止条件：如果 row == MAX_NUM，则说明已经成功找到了8个皇后的拜访位置
        // 输出结果，结束递归
        if (row == MAX_NUM) {

            printChessBoard(chessboard);

            return;
        }

        boolean[][] chessboardTemp = chessboard.clone();

        // 向这一行的每一个位置尝试摆放皇后，然后检测状态，如果符合规则就继续执行递归摆放下一个皇后
        for (int i = 0; i < MAX_NUM; i++) {
            // 摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
            for (int j = 0; j < MAX_NUM; j++) {
                chessboardTemp[row][j] = false;
            }

            chessboardTemp[row][i] = true;
            if (isQueen(chessboardTemp, row, i)) {
                findEightQueen(chessboardTemp, row + 1);
            }
        }
    }

    /**
     * 检测当前点(row, col)是否符合规则
     */
    private boolean isQueen(boolean[][] chessboard, int row, int col) {

        // 判断中上，左上，右上是否符合规则
        int step = 1;
        while (row - step >= 0) {
            // 中上
            if (chessboard[row - step][col]) {
                return false;
            }

            // 左上
            if (col - step >= 0 && chessboard[row - step][col - step]) {
                return false;
            }

            // 右上
            if (col + step < MAX_NUM && chessboard[row - step][col + step]) {
                return false;
            }

            step++;
        }

        return true;
    }

    private void printChessBoard(boolean[][] chessboard) {

        System.out.println("第 " + ++count + " 种解：");
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                System.out.print(chessboard[i][j] ? 1 : 0);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // 二维数组初始化棋盘
        boolean[][] chessboard = new boolean[MAX_NUM][MAX_NUM];

        Solution3 queenEight = new Solution3();
        long startTime = System.currentTimeMillis();
        queenEight.findEightQueen(chessboard, 0);
        System.out.println("解决" + MAX_NUM + "皇后问题，一共 " + count + " 种解法，共耗时 "
                + (System.currentTimeMillis() - startTime) + "ms");
    }
}
