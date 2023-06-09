/**
49. Group Anagrams
Medium
15.6K
445
Companies
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map <String , List<String>> AnagramGroups = new HashMap<>();
        for(String str : strs){
            char[] CharArr = str.toCharArray() ;
            Arrays.sort(CharArr);
            String sorted_str = String.valueOf(CharArr) ;
            if (!AnagramGroups.containsKey(sorted_str)){
                AnagramGroups.put(sorted_str , new ArrayList<>()) ;
            }
            AnagramGroups.get(sorted_str).add(str) ; 
        } 
        return new ArrayList<>(AnagramGroups.values()) ;
    }
}