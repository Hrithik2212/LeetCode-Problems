// A message containing letters from A-Z can be encoded into numbers using the following mapping:

// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

// Given a string s containing only digits, return the number of ways to decode it.

// The test cases are generated so that the answer fits in a 32-bit integer.

 

// Example 1:

// Input: s = "12"
// Output: 2
// Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// Example 2:

// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
// Example 3:

// Input: s = "06"
// Output: 0
// Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 

// Constraints:

// 1 <= s.length <= 100
// s contains only digits and may contain leading zero(s).

import java.util.*;

class Solution {
    // Tabulation Approach - Bottom up 
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1] ; 
        dp[s.length()] = 1;
        for(int i=s.length()-1 ; i>=0 ; i--){
            if(s.charAt(i)=='0') dp[i] = 0 ; 
            else dp[i] = dp[i+1] ; 
            if(i+1<s.length() && (s.charAt(i) == '1' || s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                dp[i] += dp[i+2] ; 
            }
        }
        return dp[0] ;
    }
}

class Solution2 extends Solution {
    // Memoization Approach - Top Down 
    public int numDecodings(String s) {
        HashSet<Character> set = new HashSet<>();
        String temp = "0123456" ;
        for(Character c : temp.toCharArray()){
            set.add(c) ;
        }
        HashMap<Integer , Integer> cache = new HashMap<>() ;
        cache.put(s.length() , 1) ; 
        return dfs(s,0,cache , set ) ; 
    }

    public int dfs(String s , int i , HashMap<Integer, Integer> cache ,HashSet<Character> set){
        if(cache.containsKey(i)) return cache.get(i);
        if(s.charAt(i)=='0') return 0;

        int res = dfs(s , i+1,cache,set) ; 
        if(i < s.length()-1 
            && (s.charAt(i)=='1' || s.charAt(i) == '2' && set.contains(s.charAt(i+1)))){
                res += dfs(s ,i+2 , cache ,set ); 
            }
        cache.put(i , res);
        return res ;
    }
}