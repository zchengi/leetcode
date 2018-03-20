package _734_Sentence_Similarity;


import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 734. Sentence Similarity
 * <p>
 * 时间复杂度：O(len(pairs) + len(s))
 * 空间复杂度：O(len(pairs))
 * <p>
 * 对 Solution1 优化，使用 set 数据结构替代 map，
 * 将 pairs 中的所有能出现的可能性添加到 set 中，
 * 然后判断 word1 和 word2 的第 i 项的组合是否存在与 set 中，
 * 不存在就不是 Similarity。
 *
 * @author cheng
 *         2018/3/20 09:57
 */
public class Solution2 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

        if (words1.length != words2.length) {
            return false;
        }
        if (words1.length == 0) {
            return true;
        }

        Set<String> similarity = new HashSet<>();
        for (String[] pair : pairs) {
            String hashcode1 = pair[0] + "#" + pair[1];
            String hashcode2 = pair[1] + "#" + pair[0];
            similarity.add(hashcode1);
            similarity.add(hashcode2);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && !similarity.contains(words1[i] + "#" + words2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String[] word1 = {"great", "acting", "skills"};
        String[] word2 = {"fine", "drama", "talent"};
        String[][] pairs1 = {{"great", "fine"}, {"acting", "drama"}, {"skills", "talent"}};
        System.out.println(new Solution2().areSentencesSimilar(word1, word2, pairs1));

        String[] word3 = {"great"};
        String[] word4 = {"great"};
        String[][] pairs2 = {};
        System.out.println(new Solution2().areSentencesSimilar(word3, word4, pairs2));

        String[] word5 = {"great", "aaa"};
        String[] word6 = {"great", "bbb"};
        // String[][] pairs3= {{"aaa","bbb"}};
        String[][] pairs3 = {{"aaa", "aaa"}};
        System.out.println(new Solution2().areSentencesSimilar(word5, word6, pairs3));

    }
}
