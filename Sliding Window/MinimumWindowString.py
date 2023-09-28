# Given two strings s and t of lengths m and n respectively, return the minimum window 
# substring
#  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

# The testcases will be generated such that the answer is unique.

 

# Example 1:

# Input: s = "ADOBECODEBANC", t = "ABC"
# Output: "BANC"
# Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
# Example 2:

# Input: s = "a", t = "a"
# Output: "a"
# Explanation: The entire string s is the minimum window.
# Example 3:

# Input: s = "a", t = "aa"
# Output: ""
# Explanation: Both 'a's from t must be included in the window.
# Since the largest window of s only has one 'a', return empty string.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # base case 
        if t =="" or len(s) < len(t): return ""

        # Intialize and set needmap(string t) and havemap(window)
        needmap , havemap = {} , {} 
        for c in t:
            needmap[c] = needmap.get(c,0) + 1 # t char count 
            havemap[c] = 0 # intialize with t chars and 0 as value for all keys
         
        need , have  = len(needmap) , 0 
        l = 0 
        res , resLen = "" , float("infinity")
        for r in range(len(s)):
            if s[r] in needmap: # check if it is a char in t 
                havemap[s[r]] += 1 # update count in window 
                if havemap[s[r]] ==  needmap[s[r]] : # compare the count of window and t's counter 
                    have += 1 
            while(have == need) : # to reduce window size to optimal value until valid 
                if resLen > r-l+1:
                    resLen = r-l+1  # update results 
                    res = s[l:r+1]
                if s[l] in havemap :
                    havemap[s[l]] -= 1 # update window counter 
                    if needmap[s[l]] > havemap[s[l]] : 
                        have -= 1
                l+=1 # increment left pointer of the window 
        return res 
            
