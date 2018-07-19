package _010_Maze.solution1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 迷宫数据层
 *
 * @author cheng
 *         2018/7/19 14:31
 */
public class MazeData {

    public static final char ROAD = '.';
    public static final char WALL = 'X';
    private static final char ENTRANCE = 'S';
    private static final char EXIT = 'D';

    private int N, M, T;

    /**
     * 迷宫入口坐标
     */
    private int entranceX, entranceY;

    /**
     * 迷宫出口坐标
     */
    private int exitX, exitY;

    /**
     * 迷宫数组
     */
    private char[][] maze;

    /**
     * 迷宫是否走过
     */
    private boolean[][] visited;

    public MazeData(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("Filename can not be null.");
        }

        generateMaze(fileName);
    }

    private void generateMaze(String filename) {

        Scanner scanner = null;
        try {
            File file = new File(filename);
            if (!file.exists()) {
                throw new IllegalArgumentException("File " + filename + " doesn't exist.");
            }

            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "utf-8");

            // 获取第一行
            String firstLine = scanner.nextLine();
            String[] first = firstLine.trim().split("\\s+");
            N = Integer.parseInt(first[0]);
            M = Integer.parseInt(first[1]);
            T = Integer.parseInt(first[2]);

            maze = new char[N][M];
            visited = new boolean[N][M];

            // 获取后续 N 行
            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();

                // 给迷宫数组赋值
                for (int j = 0; j < M; j++) {
                    char c = line.charAt(j);
                    if (c == ENTRANCE) {
                        entranceX = i;
                        entranceY = j;
                    } else if (c == EXIT) {
                        exitX = i;
                        exitY = j;
                        maze[i][j] = ROAD;
                        continue;
                    }
                    maze[i][j] = c;
                }
            }

            // System.out.println(entranceX + "" + entranceY);
            // System.out.println(exitX + "" + exitY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
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

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public int T() {
        return T;
    }

    public int getEntranceX() {
        return entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }

    public boolean[][] getVisited() {
        return visited;
    }
}
