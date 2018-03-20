package _734_Sentence_Similarity;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 734. Sentence Similarity
 * <p>
 * 时间复杂度：O(len(pairs) + len(s))
 * 空间复杂度：O(len(pairs))
 *
 * @author cheng
 *         2018/3/19 21:27
 */
public class Solution1 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

        if (words1.length != words2.length) {
            return false;
        }
        if (words1.length == 0) {
            return true;
        }

        // 将 pairs 中的每一对单词都存入 map 中，同时反向存入
        Map<String, String> map = new HashMap<>();
        for (String[] pair : pairs) {
            String s1 = pair[0];
            String s2 = pair[1];
            map.put(s1, s2);
            map.put(s2, s1);
        }

        for (int i = 0; i < words1.length; i++) {

            String w1 = words1[i];
            String w2 = words2[i];
            if (w1.equals(w2)) {
                continue;
            }

            if (!map.containsKey(w1) || !map.get(w1).contains(w2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String[] word1 = {"great", "acting", "skills"};
        String[] word2 = {"fine", "drama", "talent"};
        String[][] pairs = {{"great", "fine"}, {"acting", "drama"}, {"skills", "talent"}};
        System.out.println(new Solution1().areSentencesSimilar(word1, word2, pairs));
    }
}
