package _126_Word_Ladder_II;

import java.util.*;

/**
 * LeetCode. 126 Word Ladder II
 * <p>
 * https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
 *
 * @author cheng
 *         2018/6/29 15:00
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);

        return res;
    }

    private void bfs(String beginWord, String endWord, HashSet<String> dict,
                     HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {

        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (endWord.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }

                if (foundEnd) {
                    break;
                }
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, HashSet<String> dict) {

        ArrayList<String> res = new ArrayList<>();
        char[] chs = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }

                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }

                chs[i] = old_ch;
            }
        }
        return res;
    }

    private void dfs(String curWord, String endWord, HashSet<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
                     HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {

        solution.add(curWord);
        if (endWord.equals(curWord)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String nextWord : nodeNeighbors.get(curWord)) {
                if (distance.get(nextWord) == distance.get(curWord) + 1) {
                    dfs(nextWord, endWord, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }

        solution.remove(solution.size() - 1);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(new Solution().findLadders(beginWord, endWord, wordList));
    }
}


