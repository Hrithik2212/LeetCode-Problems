/*
22. Generate Parentheses
Medium
18.2K
740
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class Solution {

    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    private void backtrack(int OpenN ,int  ClosedN , int n){
        if (OpenN == ClosedN && ClosedN == n){
            Iterator val = stack.iterator();
            String temp = "";
            while(val.hasNext()){
                temp = temp + val.next();
            }
            res.add(temp);
        }
        if(OpenN < n){
            stack.push('(');
            backtrack(OpenN +1 , ClosedN , n);
            stack.pop();
        }
        if(OpenN > ClosedN){
            stack.push(')');
            backtrack(OpenN , ClosedN+1, n );
            stack.pop();
        }
    }

    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n);
        return res;
    }
    
}