// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
// Example 2:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

// Constraints:

// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.

import java.util.*; 

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String , HashSet<String>> graph = new HashMap<>() ; 
        wordList.add(beginWord) ; 
        for(String s: wordList){
            graph.put(s , new HashSet<>(findOneLetterDifferenceWords(s,wordList))) ;
        }
        System.out.println(graph) ; 
        int distance = 1 ; 
        Queue<String> q = new LinkedList<>() ; 
        q.offer(beginWord) ;
        HashSet<String> vis = new HashSet<>() ; 
        vis.add(beginWord) ;
        while(!q.isEmpty()) {
            int size = q.size() ; 
            for(int i=0 ; i < size ; i++ ) {
                String curr =  q.poll();
                if(curr.equals(endWord)) return distance ; 
                for(String node : graph.get(curr)){
                    if(!vis.contains(node)) {
                        q.offer(node) ;
                        vis.add(node) ;
                    } 
                }
            }
            distance++ ; 
        }
        return 0 ; 
    }
    public List<String> findOneLetterDifferenceWords(String word, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String w : wordList) {
            if (isOneLetterDifference(word, w)) {
                res.add(w);
            }
        }
        return res;
    }

    public boolean isOneLetterDifference(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) return false; // If more than one difference, return false
            }
        }
        return diffCount == 1; // Return true if exactly one difference
    }

    // public List<String> findOneLetterDifferenceWords(String word , List<String> wordList){
    //     List<String> res = new ArrayList<>() ; 
    //     HashMap<Character , Integer > beginWord = makeCounter(word) ; 
    //     for(String w : wordList){
    //         HashMap<Character,Integer> compareWord = makeCounter(w) ; 
    //         int diff = 0 ;
    //         for(Character c:beginWord.keySet()){
    //             diff += Math.abs(beginWord.get(c) - compareWord.getOrDefault(c,0)) ; 
    //         }
    //         if(diff==1) res.add(w) ; 
    //     }
    //     return res ; 
    // }

    // public HashMap<Character , Integer> makeCounter(String word){
    //     HashMap<Character , Integer> counter = new HashMap<>() ; 
    //     for(Character c: word.toCharArray()) {
    //         counter.put(c  , counter.getOrDefault(c,0)+1) ; 
    //     }
    //     return counter ; 
    // }
}