// Given a string s, partition s such that every 
// substring
//  of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

import java.util.* ; 

class Solution {
    public boolean isPalindrome(String word ){
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>() ; 
            List<String> curr = new ArrayList<>() ; 
            backtrack(res, curr , 0 , s) ; 
            return res ; 
    }

    public void backtrack(List<List<String>> res , List<String> curr , int i , String word ){
        if(i == word.length()) {
            res.add(new ArrayList(curr)) ; 
            return ; 
        }
        for(int j = i ; j < word.length() ; j++){
            if(isPalindrome(word.substring(i,j+1))){
                curr.add(word.substring(i,j+1)) ; 
                backtrack(res, curr , j+1 , word ) ; 
                curr.remove(curr.size()-1) ; 
            }
        }
    }
}