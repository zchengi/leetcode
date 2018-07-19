package _010_Maze.solution2;

import java.util.List;

/**
 * @author cheng
 *         2018/7/19 14:20
 */
public class MazeSolver {

    private List<MazeData> data;
    private static int step = 0;

    /**
     * (x,y) 坐标偏移量：左移，上移，右移，下移
     */
    private static final int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public MazeSolver(String mazeFile) {
        data = MazeGenerate.generate(mazeFile);
    }

    public void run() {
        StringBuilder builder = new StringBuilder();

        for (MazeData maze : data) {
            builder.append(go(maze, maze.getEntranceX(), maze.getEntranceY()) ? "YES" : "NO").append("\r\n");
            step = 0;
        }
        System.out.println(builder);
    }

    private boolean go(MazeData maze, int x, int y) {
        maze.getVisited()[x][y] = true;
        step++;

        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];

            // 走迷宫
            if (maze.inArea(newX, newY) && !maze.getVisited()[newX][newY]) {
                if (maze.getMaze(newX, newY) == MazeData.ROAD) {
                    if (go(maze, newX, newY)) {
                        return true;
                    }
                    step--;
                } else if (maze.getMaze(newX, newY) == MazeData.EXIT && step == maze.getT()) {
                    return true;
                }
            }
        }

        // 结束循环没有找到出口，则迷宫无解
        return false;
    }

    public static void main(String[] args) {
        String filename = "MyDemo/_010_Maze/maze.txt";
        MazeSolver maze = new MazeSolver(filename);
        maze.run();
    }
}
