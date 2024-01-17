// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

import java.util.* ; 

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return Collections.emptyList();
        String[] map = { "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"} ; 
        List<String> res = new ArrayList<>() ; 
        backtrack(res , "" , map , digits) ; 
        return res ; 
    }

    public void backtrack(List<String> res , String curr , String[] map , String next_digits){
        if(next_digits.isEmpty()){
            res.add(curr) ; 
            return ; 
        }
        String characters = map[next_digits.charAt(0)-'2'];
        for(char c : characters.toCharArray()) {
            backtrack(res , curr+c , map , next_digits.substring(1)); 
        }
    }
}