package _002_Eight_Queens;


/**
 * DFS 求解八皇后问题
 * <p>
 * 给定初始点，找出一种解
 * <p>
 * 相关问题 LeetCode 051. N-Queens   LeetCode 052. N-Queens II
 *
 * @author cheng
 *         2018/4/15 16:14
 */
public class Solution1 {

    /**
     * 棋盘格子范围，同时也是皇后个数
     */
    private static final int MAX_NUM = 8;
    /**
     * 二维数组初始化棋盘
     */
    private boolean[][] chessboard = new boolean[MAX_NUM][MAX_NUM];


    public boolean findEightQueen(int y) {

        // 找到8个皇后
        if (y == MAX_NUM) {
            return true;
        }

        //　遍历当前行，逐一格子检验
        for (int i = 0; i < MAX_NUM; i++) {
            // 为当前行清除皇后，以免在回溯的时候出现脏数据
            for (int x = 0; x < MAX_NUM; x++) {
                chessboard[x][y] = false;
            }

            // 检查是否符合规则，如果符合，更改元素值进行下一次递归
            if (isQueen(i, y)) {
                chessboard[i][y] = true;

                // 如果递归返回的是 true，则说明下层已经找到解法，无需继续循环
                if (findEightQueen(y + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 检测当前点(x, y)是否符合规则
     */
    private boolean isQueen(int x, int y) {

        for (int i = 0; i < y; i++) {
            // 检查纵向
            if (chessboard[x][i]) {
                return false;
            }

            // 检查左侧斜向
            if (x - 1 - i >= 0 && chessboard[x - 1 - i][y - 1 - i]) {
                return false;
            }

            // 检查右侧斜向
            if (x + 1 + i < MAX_NUM && chessboard[x + 1 + i][y - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    private void printEightQueen() {
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                if (chessboard[i][j]) {
                    System.out.printf("(%d , %d) \n", i, j);
                }
            }
        }
    }

    private void printChessBoard() {
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                System.out.print(chessboard[i][j] ? 1 : 0);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution1 queenEight = new Solution1();
        queenEight.findEightQueen(0);
        queenEight.printEightQueen();
        queenEight.printChessBoard();
    }
}
