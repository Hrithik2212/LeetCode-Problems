// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
 

// // // Follow up: Could you use search pruning to make your solution faster with a larger board?

class Solution {
    
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length] ; 
        for(int r= 0 ; r < board.length ; r++ ){
            for(int c=0 ; c < board[0].length ; c++){
                if(dfs(board , vis , r, c, 0 , word )) return true ; 
            }
        }
        return false ; 

    }
    public boolean dfs(char[][] board, boolean[][] vis , int r ,int c , int idx , String word){
        if(idx == word.length()) return true ; 
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(idx) || 
        vis[r][c]) return false ; 

        vis[r][c] = true; 
        boolean res = (dfs(board , vis ,r-1 , c , idx+1 , word ) ||
                        dfs(board , vis , r , c-1 , idx+1 , word) || 
                        dfs(board , vis , r+1 , c , idx+1 , word) ||
                        dfs(board , vis , r , c+1 , idx+1 , word) ) ;
        vis[r][c] = false ;
        return res ;
    }
}