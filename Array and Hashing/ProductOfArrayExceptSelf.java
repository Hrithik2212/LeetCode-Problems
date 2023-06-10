/*
238. Product of Array Except Self
Medium
17.9K
985
Companies
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int prod = 1 ; 
        product[0] = nums[0] ;
        for(int i = 1 ; i < nums.length ; i ++ ){
            product[i] = product[i-1] * nums[i];
       }
       for(int j = nums.length-1 ; j > 0 ; j-- ){
           product[j] = product[j-1] * prod ; 
           prod *= nums[j];
       }
       product[0] = prod ;
        return product ;
    }
}