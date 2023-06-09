/*
242. Valid Anagram
Easy
9.3K
290
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/



class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map < Character , Integer > mapS= new HashMap<Character , Integer>();
        Map < Character , Integer > mapT = new HashMap<Character , Integer>();
        for(int i=0 ; i<s.length() ; i++){
            if(mapS.containsKey(s.charAt(i))) mapS.put(s.charAt(i) , mapS.get(s.charAt(i))+1);
            else mapS.put(s.charAt(i) , 1);
            if(mapT.containsKey(t.charAt(i))) mapT.put(t.charAt(i) ,mapT.get(t.charAt(i))+1);
            else mapT.put(t.charAt(i) , 1);
        }
        for(char k : mapS.keySet()){
            if (!mapS.get(k).equals(mapT.getOrDefault(k,0))) return false ;
        }
        return true ;
    }
}