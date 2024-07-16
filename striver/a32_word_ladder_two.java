package striver;

import java.util.*;

public class a32_word_ladder_two {
    public static void main(String[] args) {
        // Test case
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        
        ArrayList<ArrayList<String>> sequences = findSequences(startWord, targetWord, wordList);
        
        // Print the result
        for (ArrayList<String> sequence : sequences) {
            System.out.println(sequence);
        }
    }
    
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Convert wordList to a set for faster look-up
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        
        // Result list to store all shortest transformation sequences
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        // If the target word is not in the word list, no sequence can be found
        if (!wordSet.contains(targetWord)) {
            return result;
        }

        // Queue for BFS: each element is a path taken so far
        Queue<ArrayList<String>> queue = new LinkedList<>();
        
        // Initialize the queue with the start word path
        ArrayList<String> startPath = new ArrayList<>();
        startPath.add(startWord);
        queue.add(startPath);
        
        // Used words on the current level
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        
        int level = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            ArrayList<String> path = queue.peek();
            
            // Clear used words from previous levels
            if (path.size() > level) {
                level++;
                for (String word : usedOnLevel) {
                    wordSet.remove(word);
                }
                usedOnLevel.clear();
            }

            // Get the last word in the current path
            String lastWord = path.get(path.size() - 1);

            // If we reached the target word, add the path to the result
            if (lastWord.equals(targetWord)) {
                    result.add(new ArrayList<>(path));
                }
            

            // Explore all possible one-character transformations
            for (int i = 0; i < lastWord.length(); i++) {
                char[] charArray = lastWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String newWord = new String(charArray);

                    // If the new word is in the word set
                    if (wordSet.contains(newWord)) {
                        // Create a new path with the new word
                        ArrayList<String> newPath = new ArrayList<>(path);
                        newPath.add(newWord);
                        queue.add(newPath);
                        
                        // Mark the new word as used in the current level
                        usedOnLevel.add(newWord);
                    }
                }
            }
            
            // Remove the processed path from the queue
            queue.poll();
        }

        return result;
    }
}
