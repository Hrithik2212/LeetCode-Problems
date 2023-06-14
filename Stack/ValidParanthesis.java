/**
20. Valid Parentheses
Easy
20.2K
1.2K
Companies
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character , Character > hmap = new HashMap<>();
        hmap.put('}','{');
        hmap.put(']','[');
        hmap.put(')','(');
        for(int i = 0 ; i < s.length() ; i++ ){
            char c  = s.charAt(i);
            if(hmap.containsKey(c)){
                if(!stack.empty() && stack.peek() ==  hmap.get(c)){
                    stack.pop();
                }
                else return false ;
            }
            else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}