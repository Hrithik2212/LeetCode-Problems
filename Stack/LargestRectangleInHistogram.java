/*
84. Largest Rectangle in Histogram
Hard
14.6K
207
Companies
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
*/


class Solution {
    public int largestRectangleArea(int[] heights) {
        int max_area = 0 ; 
        Stack<Pair<Integer , Integer>> stack = new Stack<>();
        for(int i = 0 ; i < heights.length ; i++){
            int currH = heights[i];
            int start = i;
            while(!stack.empty() && currH < stack.peek().getValue()){
                Pair<Integer , Integer > pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                max_area = Math.max(max_area , h * (i-index));
                start = index ;
            }
            stack.push(new Pair(start,currH));
        }
        while(!stack.empty()){
            Pair<Integer , Integer> pair = stack.pop();
            int index  = pair.getKey();
            int h = pair.getValue();
            max_area = Math.max(max_area , h * (heights.length - index));
        }
        return max_area;
    }
}