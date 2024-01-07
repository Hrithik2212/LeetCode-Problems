// Given a string s, return the longest 
// palindromic
 
// substring
//  in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"
 

// Constraints:

// 1 <= s.length <= 1000
// s consist of only digits and English letters.

class Solution {
    public String longestPalindrome(String s) {
        String res = ""; 
        for(int i = 0 ; i < s.length() ; i++) {
            int l = i , r = i ; 
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
                String s1 = s.substring(l , r+1) ; 
                if (s1.length() > res.length()) res = s1 ; 
                l-- ; r++;
            }
            l = i ;  r = i+1; 
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)  ){
                String s1 = s.substring(l , r+1) ; 
                if (s1.length() > res.length()) res = s1 ; 
                l-- ; r++ ; 
            }
        }
        return res;
    }
}