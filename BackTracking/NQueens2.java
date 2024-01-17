// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

// Example 1:


// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:

// Input: n = 1
// Output: 1

class Solution {
    int res = 0 ;
    public int totalNQueens(int n) { 
        boolean[][] board = new boolean[n][n] ; 
        queens(board  , 0); 
        return this.res ; 
    }

    public void queens(boolean[][] board  , int row ){
        if(row == board.length) {
            this.res++; 
            return  ; 
        }
        for(int col=0;col < board[0].length ; col++){
            if(isSafe(board,row,col)) {
                board[row][col] = true ; 
                queens(board  , row+1) ; 
                board[row][col] = false ; 
            }
        }
    }


    public boolean isSafe(boolean[][] board , int row , int col ){
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][col]) return false ; 
        }

        int maxLeft = Math.min(row, col) ; 
        for(int i=1 ; i <=maxLeft ; i++){
            if(board[row-i][col-i]) return false ; 
        }

        int maxRight = Math.min(row , board.length-1-col); 
        for(int i=1;i<=maxRight ; i++){
            if(board[row-i][col+i]) return false ; 
        }

        return true ; 
    }
}
