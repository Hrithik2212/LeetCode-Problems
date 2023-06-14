/*
42. Trapping Rain Water
Hard
26.9K
369
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

class Solution {
    public int trap(int[] height) {
        // Spoace Complexity : O(1) 
        int water = 0 ; 
        int maxleft = height[0] ;
        int maxright =height[height.length-1];
        int left = 0 ;
        int right = height.length-1;
        while(left<right){
            if(maxleft < maxright){
                left++;
                water += Math.max(Math.min(maxleft,maxright)-height[left],0);
                maxleft = Math.max(maxleft , height[left] );
            }
            else {
                right--;
                 water += Math.max(Math.min(maxleft,maxright)-height[right],0);
                 maxright = Math.max(maxright , height[right] );    
            }
        }
        System.gc();
        return water;
    }

    
    public int trap2(int[] height) {
        // Space Complexity : O(N)
        int water = 0 ; 
        int[] leftmaxheight = new int[height.length];
        int[] rightmaxheight = new int[height.length];
        leftmaxheight[0] = 0;
        rightmaxheight[height.length-1] = 0;
        for(int i = 1 ; i < height.length ; i++){
            leftmaxheight[i] = Math.max(leftmaxheight[i-1] , height[i-1]) ; 
        }        
        for(int i = height.length-2 ; i>0 ;i--){
            rightmaxheight[i] = Math.max(rightmaxheight[i+1] , height[i+1]);
        }
        for(int i=0;i<height.length;i++){
            water += Math.max(Math.min(leftmaxheight[i],rightmaxheight[i])-height[i],0);
        }
        return water;
    }
}