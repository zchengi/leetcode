package _341_Flatten_Nested_List_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LeetCode 341. Flatten Nested List Iterator
 * <p>
 * 使用递归实现
 *
 * @author cheng
 *         2018/5/1 23:05
 */
public class Solution2 implements Iterator<Integer> {

    private List<NestedInteger> nestedList;
    private List<Integer> flattenedList;
    private int index;

    public Solution2(List<NestedInteger> nestedList) {

        this.nestedList = nestedList;
        flattenedList = new ArrayList<>();
        for (NestedInteger nestedIntegers : nestedList) {
            createFlattenedList(nestedIntegers, flattenedList);
        }
        index = 0;
    }

    @Override
    public Integer next() {
        return flattenedList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattenedList.size();
    }

    private void createFlattenedList(NestedInteger nestedIntegers, List<Integer> flattenedList) {

        if (nestedIntegers.isInteger()) {
            flattenedList.add(nestedIntegers.getInteger());
            return;
        }

        List<NestedInteger> lists = nestedIntegers.getList();
        for (NestedInteger sublist : lists) {
            createFlattenedList(sublist, flattenedList);
        }
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
