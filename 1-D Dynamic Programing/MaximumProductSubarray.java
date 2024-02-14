
// Given an integer array nums, find a
// subarray
// that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 

// Constraints:

//     1 <= nums.length <= 2 * 104
//     -10 <= nums[i] <= 10
//     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


class Solution {
    public int maxProduct(int[] nums) {
           int n = nums.length ;
           int res = Integer.MIN_VALUE , l = 0 , r = 0;
           for(int i=0 ; i < n ; i++){
               l = ((l==0)?1:l) * nums[i] ; 
               r = ((r==0)?1:r) * nums[n-i-1] ; 
               res = Math.max(res ,Math.max(l , r)) ; 
           }
        return res ; 
    }
}