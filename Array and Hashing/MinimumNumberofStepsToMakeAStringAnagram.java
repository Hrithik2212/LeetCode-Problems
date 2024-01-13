// You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

// Return the minimum number of steps to make t an anagram of s.

// An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

 

// Example 1:

// Input: s = "bab", t = "aba"
// Output: 1
// Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
// Example 2:

// Input: s = "leetcode", t = "practice"
// Output: 5
// Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
// Example 3:

// Input: s = "anagram", t = "mangaar"
// Output: 0
// Explanation: "anagram" and "mangaar" are anagrams. 
 

// Constraints:

// 1 <= s.length <= 5 * 104
// s.length == t.length
// s and t consist of lowercase English letters only.

class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character , Integer> s_map = new HashMap<>() ; 
        HashMap<Character , Integer> t_map = new HashMap<>() ; 
        for(int i = 0 ; i < t.length() ; i ++) {
            s_map.put(s.charAt(i) , s_map.getOrDefault(s.charAt(i),0)+1) ;
            t_map.put(t.charAt(i) , t_map.getOrDefault(t.charAt(i),0)+1) ;
        }
        int freq = 0 ; 
        for(Character c:t_map.keySet()){
            if (t_map.get(c) > s_map.getOrDefault(c ,0)){
                if (!s_map.containsKey(c)) 
                    freq += t_map.get(c) ;//Math.abs(t_map.get(c)-s_map.getOrDefault(c,0)) ; 
                else 
                    freq += Math.abs(t_map.get(c)-s_map.getOrDefault(c,0));
            }

        } 
        return freq ;
    }
}