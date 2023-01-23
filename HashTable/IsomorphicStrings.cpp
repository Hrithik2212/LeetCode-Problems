// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:

// Input: s = "egg", t = "add"
// Output: true
// Example 2:

// Input: s = "foo", t = "bar"
// Output: false
// Example 3:

// Input: s = "paper", t = "title"
// Output: true


class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char,char> hmap1 , hmap2;
        for(int i=0;i<s.size();i++){
            if(hmap1.find(s[i])==hmap1.end() && hmap2.find(t[i])==hmap2.end()){
                hmap1[s[i]] = t[i] ;
                hmap2[t[i]] = s[i] ;
            }
            else{
                if(hmap1[s[i]] != t[i] || hmap2[t[i]] != s[i]){
                    return false;
                }
            }
        }
        return true;
    }
};