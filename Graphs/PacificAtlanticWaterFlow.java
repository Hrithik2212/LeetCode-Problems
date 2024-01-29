// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

 

// Example 1:


// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
// [0,4]: [0,4] -> Pacific Ocean 
//        [0,4] -> Atlantic Ocean
// [1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//        [1,3] -> [1,4] -> Atlantic Ocean
// [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//        [1,4] -> Atlantic Ocean
// [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
// [3,0]: [3,0] -> Pacific Ocean 
//        [3,0] -> [4,0] -> Atlantic Ocean
// [3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//        [3,1] -> [4,1] -> Atlantic Ocean
// [4,0]: [4,0] -> Pacific Ocean 
//        [4,0] -> Atlantic Ocean
// Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
// Example 2:

// Input: heights = [[1]]
// Output: [[0,0]]
// Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 

// Constraints:

// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 105

import java.util.* ; 

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length , cols = heights[0].length ; 
        boolean[][] pacific = new boolean[rows][cols] ;
        boolean[][] atlantic = new boolean[rows][cols] ; 
        for(int c=0 ; c < cols ; c++){
            dfs(0 , c , pacific , heights[0][c] , heights) ; 
            dfs(rows-1 , c , atlantic , heights[rows-1][c] , heights ) ; 
        }
        for(int r=0 ;r < rows ;r++){
            dfs(r,0 ,pacific , heights[r][0] , heights) ;
            dfs(r ,cols-1 ,atlantic , heights[r][cols-1] , heights) ;
        }

        List<List<Integer>> res = new ArrayList<>() ;
        for(int r =0 ; r <rows ; r++) {
            for(int c= 0 ; c < cols ; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    List<Integer> ans = new ArrayList<>() ; 
                    ans.add(r) ; 
                    ans.add(c) ;
                    res.add(ans) ;
                }
            }
        }
        return res ;

    }

    public void dfs(int r , int c , boolean[][] vis , int prevHeight , int[][] grid){
        if( r>=0 && c>=0 && r < grid.length && c < grid[0].length && !vis[r][c] && grid[r][c] >= prevHeight ){
            vis[r][c] = true ; 
            dfs(r+1 ,c ,vis ,grid[r][c] , grid) ; 
            dfs(r ,c+1 ,vis ,grid[r][c] , grid) ; 
            dfs(r-1 ,c ,vis ,grid[r][c] , grid) ;
            dfs(r ,c-1 ,vis ,grid[r][c] , grid) ;
        }
    }
}