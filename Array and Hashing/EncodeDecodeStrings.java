/*
659 · Encode and Decode Strings
Algorithms
Medium
Accepted Rate
65%
Description
Solution27
Notes
Discuss94
Leaderboard
Record

Description
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Only $39.9 for the "Twitter Comment System Project Practice" within a limited time of 7 days!

WeChat Notes Twitter for more information（WeChat ID jiuzhang104）


Example
Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
Example2

Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes
*/

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution{
    public String encode(List<Strings> strs){
        String res = new StringBuilder();
        for(String str : strs){
            res.append(str.length()).append("#").append(str);
        }
        return res.toString() ; 
    }
    
    public List<String> decode(String str){
        List<String> res = new ArrayList<>() ; 
        int i = 0 ;
        while(i < str.length()){
            int j = i ; 
            while(str.charAt(j) != '#') j++ ;
            int length = Integer.valueOf(str.substring(i,j));
            res.add(str.substring(j+1,j+1+length));
            i = j+1+length ; 
        }
        return res;
    }
}
