"""Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
"""

class Solution(object):
    def check( self ,s ) :
        return s == s[::-1]
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if (self.check(s)):
            return s
        if len(s) == 1 :
            return s
        r = ""
        for i in range(len(s)):
            for j in range(i,len(s)+1):
                s1 = s[i:j]
                if (self.check( s1 )):
                    if len(r) < len(s[i:j]) :
                        r = s[i:j]
        return r 
      
"""
Input
s =
"babad"
Output
"bab"
Expected
"bab"
"""
