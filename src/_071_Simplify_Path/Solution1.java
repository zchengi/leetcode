package _071_Simplify_Path;

import java.util.*;

/**
 * LeetCode 071. Simplify Path
 *
 * @author cheng
 *         2018/4/28 23:30
 */
public class Solution1 {
    public String simplifyPath(String path) {

        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }

        StringBuilder res = new StringBuilder();

        for (String dir : stack) {
            res.insert(0, "/" + dir);
        }

        return res.length() == 0 ? "/" : res.toString();
    }

    public static void main(String[] args) {
        String path = "/..";
        System.out.println(new Solution1().simplifyPath(path));

        path = "/a/./b/../../c/";
        System.out.println(new Solution1().simplifyPath(path));

        path = "/../";
        System.out.println(new Solution1().simplifyPath(path));

        path = "/home//foo/";
        System.out.println(new Solution1().simplifyPath(path));
    }
}
