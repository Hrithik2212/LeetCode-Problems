// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.

// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

 

// Constraints:

//     1 <= s.length <= 300
//     1 <= wordDict.length <= 1000
//     1 <= wordDict[i].length <= 20
//     s and wordDict[i] consist of only lowercase English letters.
//     All the strings of wordDict are unique

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1] ;
        Arrays.fill(dp , false ) ;
        dp[s.length()] = true ; 
        for(int i=s.length()-1 ; i>=0 ; i--){
            for(String word : wordDict){
                int j = i+word.length() ;
                if(j<=s.length()){
                    String s1 = s.substring(i,j);
                    if(s1.equals(word) ) 
                        dp[i] = dp[j] ; 
                    if(dp[i])
                        break ; 
                }
                
            }
        } 
        return dp[0] ; 
    }
}