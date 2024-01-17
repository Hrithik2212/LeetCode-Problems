// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

// Example 1:


// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:

// Input: n = 1
// Output: [["Q"]]

import java.util.* ;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n] ;
        List<List<String>> res = new ArrayList<>() ; 
        queens(board , res , 0); 
        return res ; 
    }

    public void queens(boolean[][] board,List<List<String>> res , int row ){
        if(row == board.length){
            List<String> ans = new ArrayList<>() ; 
            createAnswer(board , ans );
            res.add(ans) ; 
            return ;
        }
        for(int col=0 ; col<board[0].length; col++){
            if (isSafe(board , row ,col)){
                board[row][col] = true ; 
                queens(board , res , row+1 ) ; 
                board[row][col] = false ; 
            }
        }
    }

    public void createAnswer(boolean[][] board , List<String> ans){
        for(int i=0;i <board.length ; i++){
            StringBuilder str = new StringBuilder("") ; 
            for(int j=0 ; j<board[0].length ; j++) {
                if (board[i][j]) str.append("Q");
                else str.append(".");
            }
            ans.add(str.toString()) ; 
        }
    }

    public boolean isSafe(boolean[][] board , int row , int col ){
        for (int i = 0 ; i < board.length ; i ++){
            if(board[i][col]) return false ; 
        }
        
        int maxLeft = Math.min(row , col ); 
        for(int i = 1 ; i <= maxLeft ; i++ ){
            if(board[row-i][col-i]) return false ;
        }

        int maxRight = Math.min(row , board.length-1-col) ; 
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]) return false ;
        }
        return true ; 
    }
}