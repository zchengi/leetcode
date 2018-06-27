package problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author cheng
 *         2018/5/30 20:09
 */
public class Test {

    public static void test1(String str) {

        Map<Integer, Integer> map = new HashMap<>();
        for (String num : str.split(" ")) {
            map.put(Integer.valueOf(num.substring(num.length() - 3, num.length())), Integer.valueOf(num));
        }

        Set<Integer> sets = map.keySet();
        int[] keys = new int[sets.size()];
        int i = 0;
        for (Integer num : sets) {
            keys[i++] = num;
        }

        Arrays.sort(keys);
        for (int j = 0; j < sets.size(); j++) {
            System.out.print(map.get(keys[j]) + " ");
        }

        System.out.println();
    }

    public static void test2(String str) {

        String[] values = str.split(" ");

        int[] keys = new int[values.length];
        int[] indexes = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            indexes[i] = i;
            keys[i] = Integer.parseInt(values[i].substring(values[i].length() - 3, values[i].length()));
        }

        sort(keys, indexes);

        for (int index : indexes) {
            System.out.print(values[index] + " ");
        }
    }

    private static void sort(int[] keys, int[] indexes) {

        int n = keys.length;
        for (int i = 0; i < n; i++) {
            int temp = indexes[i];

            int j;
            for (j = i; j > 0 && keys[temp] < keys[indexes[j - 1]]; j--) {
                indexes[j] = indexes[j - 1];
            }
            indexes[j] = temp;
        }
    }


    public static void main(String[] args) {

        String str = "432543 234 453434 3244543 5456994 9977745";
        test1(str);
        test2(str);
    }
}
