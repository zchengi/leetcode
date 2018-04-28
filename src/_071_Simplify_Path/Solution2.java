package _071_Simplify_Path;

/**LeetCode 071. Simplify Path
 *
 * <p>
 * 采用从后向前遍历的方式 :)
 * 很酷的方法
 *
 * @author cheng
 *         2018/4/29 00:28
 */
public class Solution2 {
    public String simplifyPath(String path) {

        // 最后一个索引
        int i = path.length() - 1;
        // ".." 的符号数量，即需要回退的层数
        int count = 0;
        // 返回的结果
        StringBuilder result = new StringBuilder();

        // 如果索引大于等于0
        while (i >= 0) {
            // 如果当前索引的字符为 '/'，则 i--
            while (i >= 0 && path.charAt(i) == '/') {
                i--;
            }

            // 如果当前索引的字符不为 '/'，则 j--
            int j = i - 1;
            while (j >= 0 && path.charAt(j) != '/') {
                j--;
            }

            // 如果 j >= -1 ；只能在循环1中出现这种情况，因为 Unix 根为 '/'，即 索引0的位置一定是'/'
            if (j >= -1) {
                // 取出 索引 j+1 到 i+1 的字符
                String temp = path.substring(j + 1, i + 1);
                if (temp.equals("..")) {
                    // 判断 temp 是否为 ".."，如果是，则 count++，需要回退一层目录
                    count++;
                } else if (temp.equals(".") || temp.equals("")) {
                    // 如果 temp 为 "." 或为空，则证明是当前目录，不需要做任何操作
                } else if (count > 0) {
                    // 如果 count > 0，则证明要回退到上一级目录，当前目录不能添加
                    count--;
                } else {
                    // 不满足以上情况，则添加新目录 / + temp
                    result.insert(0, "/" + temp);
                }
            }

            // 索引 i 变为 未遍历的第一个索引位置
            i = j - 1;
        }

        // 如果 result 为空则返回根目录 "/"，否则返回结果目录
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        String path = "/..";
        System.out.println(new Solution2().simplifyPath(path));

        path = "/a/./b/../../c/";
        System.out.println(new Solution2().simplifyPath(path));

        path = "/../";
        System.out.println(new Solution2().simplifyPath(path));

        path = "/home//foo/";
        System.out.println(new Solution2().simplifyPath(path));
    }
}
