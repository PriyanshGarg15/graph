package striver;

import java.util.*;

public class a31_word_ladder_one_leetcode_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentWord = current.word;
            int level = current.level;
            
            char[] wordArray = currentWord.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                char originalChar = wordArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if (newWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (wordSet.contains(newWord)) {
                        queue.add(new Pair(newWord, level + 1));
                        wordSet.remove(newWord);
                    }
                }
                wordArray[i] = originalChar;
            }
        }
        return 0;
    }

    class Pair {
        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        a31_word_ladder_one_leetcode_127 solver = new a31_word_ladder_one_leetcode_127();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        int result = solver.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + result);
    }
}
