package _692_Top_K_Frequent_Words;

import java.util.*;

/**
 * LeetCode 692. Top K Frequent Words
 *
 * @author cheng
 *         2018/08/22 14:27
 */
public class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 最小队列
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                // 如果 a,b 的值相等: 比较 b,a 的字母顺序，较低的在前，即如果 b.getKey().compareTo(a.getKey()) = 1，交换位置
                // 如果 a,b 的值不相等: 比较 a,b 的值大小，较小的前面，即如果 a.getValue() - b.getValue() > 0，交换位置
                (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // 将 map 中的数据插入优先队列
            pq.offer(entry);
            // 如果优先队列的元素个数大于k，则删除最小元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        /*map.entrySet().forEach(entry -> {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        });*/


        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {

        String[] word = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new Solution1().topKFrequent(word, k));

        word = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        k = 4;
        System.out.println(new Solution1().topKFrequent(word, k));
    }
}
