// You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

//     0 <= j <= nums[i] and
//     i + j < n

// Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:

// Input: nums = [2,3,0,1,4]
// Output: 2

 

// Constraints:

//     1 <= nums.length <= 104
//     0 <= nums[i] <= 1000
//     It's guaranteed that you can reach nums[n - 1].

class Solution {
    public int jump(int[] nums) {
        int minJump[] = new int[nums.length] ;
        Arrays.fill(minJump , 10001 );
        minJump[nums.length-1] = 0 ;
        for(int pos=nums.length-2 ; pos >= 0 ; pos--){
            int step = pos+1 ;
            while( step < nums.length && nums[pos] > 0){
                minJump[pos] = Math.min(minJump[pos] , minJump[step]+1) ;
                step ++ ;
                nums[pos]-- ;
            }
        }
        return minJump[0] ;
    }
}