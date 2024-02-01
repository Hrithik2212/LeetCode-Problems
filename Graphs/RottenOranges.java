// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

import java.util.* ; 

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>() ; 
        int m = grid.length , n= grid[0].length  ; 
        int time = 0 ; int fresh = 0 ; 
        for(int r=0 ; r <m ; r++){
            for(int c=0 ;c<n ;c++){
                if(grid[r][c] == 2){
                    q.offer(new int[] {r,c}) ;
                }
                else if (grid[r][c] == 1){
                    fresh++ ; 
                }
            }
        }  
        int directions[][] = {{1,0} , {0,1} , {-1,0} ,{0,-1}} ; 
        while (!q.isEmpty() && fresh>0 ){
            int sz = q.size() ; 
            for(int i=0 ; i < sz ; i++){
                int orange[] = q.poll() ; 
                for(int[] dir : directions){
                    int x = dir[0] + orange[0] , y = dir[1] + orange[1] ;
                    if(x >= 0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        grid[x][y] = 2;
                        fresh-- ;
                        q.offer(new int[]{x,y}) ;
                    }
                }
            }
            time++ ; 
        }
        return (fresh==0)?time : -1 ;
    }
}