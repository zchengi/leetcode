package _004_equals_hasCode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author cheng
 *         2018/5/22 23:06
 */
public class Test {

    private Integer num;

    public Test(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(num, test.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    public static void main(String[] args) {

        HashMap<Test, Integer> map = new HashMap<>();
        Test t1 = new Test(1);
        Test t2 = new Test(1);

        System.out.println(t1.equals(t2));
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());

        map.put(t1, 1);
        map.put(t2, 2);

        System.out.println(map.get(t1));
        System.out.println(map.get(t2));

    }
}
