package TestTreeSet;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * TreeSet 的 subSet 方法：
 * subSet方法返回的是同一个对象的引用，只是元素索引位置不一样。
 * 所以在原Set中增加元素，会直接影响到subSet中获取的值。
 * 记录两个位置 lo 和 hi
 *
 * @author cheng
 *         2018/7/11 17:50
 */
public class SubSetMethod {
    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();
        TreeSet<Integer> subs;
        for (int i = 606; i < 613; i++) {
            if (i % 2 == 0) s.add(i);
        }
        subs = (TreeSet<Integer>) s.subSet(608, true, 611, true);

        s.add(629);
        System.out.println(s + " " + subs);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set);
    }
}
