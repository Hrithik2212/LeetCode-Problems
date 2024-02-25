/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.



Constraints:

    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104

*/

import java.util.* ; 

class Solution {
    public int[][] merge(int[][] intervals) {
        int i = 0 ;
        List<int[]> ans = new ArrayList<>() ;
        Arrays.sort(intervals ,(i1,i2) -> Integer.compare(i1[0] , i2[0])) ;
        while (i < intervals.length-1) {
            if(intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = Math.min(intervals[i][0] , intervals[i+1][0]) ;
                intervals[i+1][1] = Math.max(intervals[i][1] , intervals[i+1][1]) ;
                i++ ;
                continue ;
            }
            ans.add(intervals[i]) ;
            i++ ;
        }
        ans.add(intervals[i]) ;
        int[][] res = new int[ans.size()][2] ;
        for(int j=0 ; j<ans.size() ; j++){
            res[j][0] = ans.get(j)[0] ;
            res[j][1] = ans.get(j)[1] ;
        }
        return res;
    }
}
