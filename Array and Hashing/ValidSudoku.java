/**
 * 36. Valid Sudoku
Medium
8.8K
920
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */

class Solution {
    public boolean checkBlock(int x , int y ,char[][] board){
        Set<Character> block = new HashSet<>();
        int endx = x+3 ; 
        int endy = y+3 ; 
        for(int i=x ; i<endx ; i++){
            for(int j=y;j<endy ; j++){
                if(board[i][j] == '.') continue ;
                else {
                    if(block.contains(board[i][j])) return false ;
                    block.add(board[i][j]);
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = null ; 
        Set<Character> cols = null ; 

        for(int i=0 ; i < 9 ; i ++){
            rows = new HashSet<>() ; 
            cols = new HashSet<>() ;
            for(int j = 0 ; j < 9 ; j ++){
                // Step 1 : Check for duplicates in rows 
                if(board[i][j] != '.'){
                    if(rows.contains(board[i][j]))
                        return false ;
                    else{
                        rows.add(board[i][j]);
                    }
                }
                // Step 2 : Check for duplicates in cols 
                if(board[j][i] != '.'){
                    if(cols.contains(board[j][i]))
                        return false ;
                    else{
                        cols.add(board[j][i]);
                    }
                }
            }
        }
        // Step 3 : Check for duplicates in blocks 
        for(int i = 0 ; i < 9 ; i=i+3){
            for(int j = 0 ; j <9 ; j=j+3){
                if(!checkBlock(i,j,board)){
                    return false ;
                }
            }
        }
        return true ;
    }
}