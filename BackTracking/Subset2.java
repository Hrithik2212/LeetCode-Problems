// Given an integer array nums that may contain duplicates, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>() ; 
        List<Integer> set = new ArrayList<>() ; 
        backtrack(res,set,nums,0); 
        return res ;
    }

    public void backtrack(List<List<Integer>> res , List<Integer> set , int[] nums , int idx){
        if(idx == nums.length){
            res.add(new ArrayList(set)) ; 
            return ; 
        }
        set.add(nums[idx]) ; 
        backtrack(res,set,nums,idx+1) ; 
        set.remove(set.size()-1) ; 
        while (idx+1 != nums.length && nums[idx] == nums[idx+1]) idx++ ; 
        backtrack(res,set,nums,idx+1) ; 
    }
}