package _451_Characters_By_Frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * LeetCode 451. Characters By Frequency
 * <p>
 * 用 java8 的新规则
 * 虽然代码看起来更简洁了 ······ 但是运行时间更久了
 * LeetCode 运行需要 110ms
 *
 * @author cheng
 *         2018/3/17 19:27
 */
public class Solution2 {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        IntStream.range(0, s.length())
                .forEach(i -> map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1));

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            IntStream.range(0, (int) e.getValue()).forEach(i -> builder.append(e.getKey()));
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        String s = "Aabb";
        System.out.println(new Solution2().frequencySort(s));

        s = "cccaaa";
        System.out.println(new Solution2().frequencySort(s));
    }
}
