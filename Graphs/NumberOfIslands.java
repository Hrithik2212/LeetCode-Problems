// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0 ; 
        boolean vis[][] = new boolean[grid.length][grid[0].length] ; 
        for(int i = 0 ; i < grid.length ; i++){
            for(int j=0 ; j < grid[0].length ; j++){
                if(!vis[i][j] && grid[i][j] != '0'){
                    dfs(grid , vis , i , j ); 
                    res++ ; 
                }
            }
        }
        return res ; 
    }
    public void dfs(char[][] grid , boolean[][] vis , int row , int col){
        if( row < grid.length && col < grid[0].length && row >= 0 && col >= 0 && !vis[row][col] ){
            vis[row][col] = true ; 
            if(grid[row][col] == '1') {
                dfs(grid , vis  , row+1 ,col ) ; 
                dfs(grid , vis , row , col+1) ; 
                dfs(grid , vis , row-1 , col) ; 
                dfs(grid , vis , row , col-1) ; 
            }
        }
    }
}