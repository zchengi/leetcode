package _341_Flatten_Nested_List_Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 341. Flatten Nested List Iterator
 * <p>
 * 使用栈实现
 *
 * @author cheng
 *         2018/5/1 22:52
 */
public class Solution1 implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();

    public Solution1(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty()) {
            NestedInteger cur = stack.peek();
            if (cur.isInteger()) {
                return true;
            }
            stack.pop();

            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }

        return false;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
