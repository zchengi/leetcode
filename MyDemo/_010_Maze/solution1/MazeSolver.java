package _010_Maze.solution1;

/**
 * @author cheng
 *         2018/7/19 14:20
 */
public class MazeSolver {

    private MazeData data;

    private int step = -1;

    /**
     * (x,y) 坐标偏移量：左移，上移，右移，下移
     */
    private static final int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public MazeSolver(String mazeFile) {
        data = new MazeData(mazeFile);
    }

    public String run() {
        return go(data.getEntranceX(), data.getEntranceY()) ? "YES" : "NO";
    }

    private boolean go(int x, int y) {
        data.getVisited()[x][y] = true;
        step++;

        if (x == data.getExitX() && y == data.getExitY() && step == data.T()) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];

            // 走迷宫
            if (data.inArea(newX, newY) && data.getMaze(newX, newY) == MazeData.ROAD && !data.getVisited()[newX][newY]) {
                //如果找到出口
                if (go(newX, newY)) {
                    return true;
                }
                step--;
            }
        }

        // 结束循环没有找到出口，则迷宫无解
        return false;
    }

    public static void main(String[] args) {
        String filename = "MyDemo/_010_Maze/maze.txt";
        MazeSolver maze = new MazeSolver(filename);
        System.out.println(maze.run());
    }
}
