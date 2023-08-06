/*
424. Longest Repeating Character Replacement
Medium
9K
383
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achive this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0 ; 
        HashMap <Character , Integer > hmap = new HashMap<>() ; 
        int result = 0 ;
        for(int r= 0 ; r < s.length() ; r++){
            hmap.put(s.charAt(r) , hmap.getOrDefault(s.charAt(r), 0 )+1);
            while((r-l+1) - Collections.max(hmap.values()) > k  ){
                hmap.put(s.charAt(l) , hmap.get(s.charAt(l))-1);
                l++;
            }
            result = Math.max(result , r-l+1 ) ; 
        }
        return result ; 
    }
}