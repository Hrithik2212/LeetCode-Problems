// You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

// Return the maximum possible length of s.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

// Example 1:

// Input: arr = ["un","iq","ue"]
// Output: 4
// Explanation: All the valid concatenations are:
// - ""
// - "un"
// - "iq"
// - "ue"
// - "uniq" ("un" + "iq")
// - "ique" ("iq" + "ue")
// Maximum length is 4.
// Example 2:

// Input: arr = ["cha","r","act","ers"]
// Output: 6
// Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
// Example 3:

// Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
// Output: 26
// Explanation: The only string in arr has all 26 characters.
 

// Constraints:

// 1 <= arr.length <= 16
// 1 <= arr[i].length <= 26
// arr[i] contains only lowercase English letters.


import java.util.* ; 


class Solution {
    public int maxLength(List<String> arr) {
        List<String> all = new ArrayList<>() ; 
        //HashSet<Character> set = new HashSet<>() ;
        dfs(all , "" , new HashSet<>() , 0 , arr) ; 
        int res = 0 ; 
        for(String s : all  )
            res = Math.max(res, s.length()) ;    
        return res ; 
    }

    public void dfs(List<String> res , String curr , HashSet<Character> set , int idx , List<String> arr ){
        if(arr.size() == idx) return ; 
        HashSet<Character> newSet = new HashSet<>(set) ;
        dfs(res, curr , newSet , idx+1 , arr) ;
        String word = arr.get(idx);
        for(Character c:word.toCharArray()) {
            if (newSet.contains(c)) return ;
            newSet.add(c) ; 
        }
        res.add(curr+word) ; 
        dfs(res , curr+word , newSet , idx+1 ,arr) ; 
        
    }
}