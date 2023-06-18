/*
704. Binary Search
Easy
9.8K
198
Companies
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
*/

class Solution {
    public int search(int[] nums, int target) {
        return bsearch(nums,0,nums.length,target);
    }
    public int bsearch(int[] nums,int l , int h , int target ){
        if( h<=l) return -1;
        int mid = (h+l)/2;
        if(nums[mid]==target) return mid ;
        else if(target < nums[mid]) return bsearch(nums,l,mid,target);
        else return bsearch(nums,mid+1,h,target);
    }
}