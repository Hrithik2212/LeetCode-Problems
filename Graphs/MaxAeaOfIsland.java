// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

 

// Example 1:


// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
// Example 2:

// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0 ; 
        boolean vis[][] = new boolean[grid.length][grid[0].length] ; 
        for(int i = 0 ; i < grid.length ; i++){
            for(int j=0 ; j < grid[0].length ; j++){
                if(!vis[i][j] && grid[i][j] != 0 ){
                    max = Math.max(max , dfs(grid , vis , i , j )); 
    
                }
            }
        } 
        return max ; 
    }

    public int  dfs(int[][] grid , boolean[][] vis , int row , int col){
        if( row < grid.length && col < grid[0].length && row >= 0 && col >= 0 && !vis[row][col] ){
            vis[row][col] = true ; 
            if(grid[row][col] == 1) {
                return dfs(grid , vis  , row+1 ,col ) + dfs(grid , vis , row , col+1) + dfs(grid , vis , row-1 , col) + dfs(grid , vis , row , col-1)  + 1; 
            }
        }
        return 0 ; 
    }
}