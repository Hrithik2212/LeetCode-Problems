# Given a string s, return the longest 
# palindromic
 
# substring
#  in s.

 

# Example 1:

# Input: s = "babad"
# Output: "bab"
# Explanation: "aba" is also a valid answer.
# Example 2:

# Input: s = "cbbd"
# Output: "bb"
 

# Constraints:

# 1 <= s.length <= 1000
# s consist of only digits and English letters.

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = "" 
        for i in range(len(s)):
            l,r = i , i 
            # odd case 
            while(l >= 0 and r < len(s) and s[l]==s[r]) : 
                s1 = s[l:r+1] 
                if (len(s1) > len(res) ) : res = s1 
                l = l-1 
                r = r+1 

            # even case 
            l , r = i , i+1
            while(l>= 0 and r<len(s) and s[l]==s[r]) : 
                s1 = s[l:r+1] 
                if (len(s1) > len(res)) : res = s1 
                l = l-1 
                r = r+1 
            
        return res 
