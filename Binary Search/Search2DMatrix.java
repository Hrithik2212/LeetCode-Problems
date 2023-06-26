/*
74. Search a 2D Matrix
Medium
12.7K
355
Companies
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length ; 
        int l = 0 ; 
        int h = rows-1 ;
        while (h>=l){
            int m = (l+h)/2;
            if(target > matrix[m][cols-1]) l = m+1;
            else if ( target < matrix[m][0]) h = m-1;
            else break ;
        }
        if(!(l<=h)) return false ;
        int row = (l+h)/2;
        l = 0 ; h = cols-1;
        while(h>=l){
            int m = (l+h)/2 ;
            if(target > matrix[row][m]) l = m+1 ;
            else if (target < matrix[row][m]) h = m-1 ;
            else return true ;
        }
        return false ;
    }
}