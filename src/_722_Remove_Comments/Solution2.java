package _722_Remove_Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 722 Remove Comments
 * <p>
 * 合并 Solution1 的 if 语句，代码量减少，但是运行慢了
 *
 * @author cheng
 *         2018/7/18 20:38
 */
public class Solution2 {
    public List<String> removeComments(String[] source) {

        List<String> result = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        boolean isBlockComments = false;

        for (String line : source) {

            // 获取数组每一项的字符数组
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {

                // 如果当前状态为块注释开始
                if (isBlockComments) {
                    if (chars[i] == '*' && i < chars.length - 1 && chars[i + 1] == '/') {
                        isBlockComments = false;
                        i++;
                    }
                    continue;
                }

                // 当前为：//
                if (chars[i] == '/' && i < chars.length - 1 && chars[i + 1] == '/') {
                    break;
                }
                // 当前为：/*
                else if (chars[i] == '/' && i < chars.length - 1 && chars[i + 1] == '*') {
                    isBlockComments = true;
                    i++;
                } else {
                    newLine.append(chars[i]);
                }
            }

            // 当前不在块注释内且 newLine 的长度大于0
            if (!isBlockComments && newLine.length() > 0) {
                result.add(newLine.toString());
                newLine = new StringBuilder();
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String[] source = {"/*Test program */", "int main()",
                "{ ", "  // variable declaration ", "int a, b, c;",
                "/* This is a test", "   multiline  ", "   comment for ",
                "   testing */", "a = b + c;", "}"};
        // Arrays.stream(source).forEach(System.out::println);

        new Solution2().removeComments(source).forEach(System.out::println);

        System.out.println();

        String[] source2 = {"a/*comment", "line", "more_comment*/b"};
        new Solution2().removeComments(source2).forEach(System.out::println);
    }
}
