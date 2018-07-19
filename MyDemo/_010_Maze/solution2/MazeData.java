package _010_Maze.solution2;

/**
 * 迷宫数据层
 *
 * @author cheng
 *         2018/7/19 14:31
 */
public class MazeData {

    public static final char ROAD = '.';
    public static final char WALL = 'X';
    public static final char ENTRANCE = 'S';
    public static final char EXIT = 'D';

    private int N, M, T;

    /**
     * 迷宫入口坐标
     */
    private int entranceX, entranceY;

    /**
     * 迷宫数组
     */
    private char[][] maze;

    /**
     * 迷宫是否走过
     */
    private boolean[][] visited;

    public MazeData(int n, int m, int t) {
        N = n;
        M = m;
        T = t;

        maze = new char[N][M];
        visited = new boolean[N][M];
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public char getMaze(int i, int j) {
        if (!inArea(i, j)) {
            throw new IllegalArgumentException("i or j is out of index in getMaze()!");
        }
        return maze[i][j];
    }

    public void print() {
        System.out.println(N + " " + M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public int getT() {
        return T;
    }

    public int getEntranceX() {
        return entranceX;
    }

    public void setEntranceX(int entranceX) {
        this.entranceX = entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }

    public void setEntranceY(int entranceY) {
        this.entranceY = entranceY;
    }

    public char[][] getMaze() {
        return maze;
    }

    public boolean[][] getVisited() {
        return visited;
    }
}
