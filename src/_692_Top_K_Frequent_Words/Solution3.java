package _692_Top_K_Frequent_Words;

import java.util.*;

/**
 * LeetCode 692. Top K Frequent Words
 *
 * @author cheng
 *         2018/08/22 15:22
 */
public class Solution3 {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new LinkedList<>();
        Map<String, WordFrequency> map = new HashMap<>();

        for (String word : words) {
            WordFrequency existing = map.get(word);
            if (existing == null) {
                map.put(word, new WordFrequency(word, 1));
            } else {
                existing.increment();
                map.put(word, existing);
            }
        }

        PriorityQueue<WordFrequency> pq = new PriorityQueue<>();
        for (WordFrequency freq : map.values()) {
            pq.offer(freq);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result.add(0, pq.poll().word);
        }

        return result;
    }

    private class WordFrequency implements Comparable<WordFrequency> {

        public String word;
        public int freq;

        WordFrequency(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(WordFrequency other) {
            if (other.freq != this.freq) {
                return this.freq - other.freq;
            }

            return other.word.compareTo(this.word);
        }

        void increment() {
            this.freq++;
        }
    }

    public static void main(String[] args) {

        String[] word = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new Solution3().topKFrequent(word, k));

        word = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        k = 4;
        System.out.println(new Solution3().topKFrequent(word, k));
    }
}
