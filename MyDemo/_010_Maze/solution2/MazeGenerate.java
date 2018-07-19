package _010_Maze.solution2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cheng
 *         2018/7/19 16:21
 */
public class MazeGenerate {

    private static List<MazeData> res = new ArrayList<>();
    private static Scanner scanner = null;

    public static List<MazeData> generate(String filename) {

        if (filename == null) {
            throw new IllegalArgumentException("Filename can not be null.");
        }

        try {
            File file = new File(filename);
            if (!file.exists()) {
                throw new IllegalArgumentException("File " + filename + " doesn't exist.");
            }

            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "utf-8");

            while (scanner.hasNextLine()) {
                generate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return res;
    }

    private static void generate() {

        // 获取第一行
        String firstLine = scanner.nextLine();
        String[] first = firstLine.trim().split("\\s+");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int T = Integer.parseInt(first[2]);

        MazeData data = new MazeData(N, M, T);

        // 获取后续 N 行
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();

            // 给迷宫数组赋值
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if (c == MazeData.ENTRANCE) {
                    data.setEntranceX(i);
                    data.setEntranceY(j);
                }
                data.getMaze()[i][j] = c;
            }
        }

        // data.print();
        // System.out.println(entranceX + "" + entranceY);
        // System.out.println(exitX + "" + exitY);

        res.add(data);
    }
}
