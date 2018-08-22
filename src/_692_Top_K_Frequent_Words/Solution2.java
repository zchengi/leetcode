package _692_Top_K_Frequent_Words;

import java.util.*;

/**
 * LeetCode 692. Top K Frequent Words
 *
 * @author cheng
 *         2018/08/22 15:17
 */
public class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 最小队列
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            int v1 = map.get(s1);
            int v2 = map.get(s2);

            if (v1 == v2) {
                return s1.compareTo(s2);
            }

            return v2 - v1;
        });

        pq.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }

    public static void main(String[] args) {

        String[] word = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new Solution2().topKFrequent(word, k));

        word = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        k = 4;
        System.out.println(new Solution2().topKFrequent(word, k));
    }
}
