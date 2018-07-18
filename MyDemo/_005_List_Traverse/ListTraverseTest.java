package _005_List_Traverse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 不要在 foreach 循环里进行元素的 remove / add 操作。
 * remove 元素请使用 Iterator 方式，如果并发操作，需要对 Iterator 对象加锁。
 *
 * @author cheng
 *         2018/5/30 11:32
 */
public class ListTraverseTest {

    private static void foreachTest(List<String> list) {

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list);
    }

    private static void iteratorTest(List<String> list) {

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        // foreachTest(list);
        iteratorTest(list);
    }
}
