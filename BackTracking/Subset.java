// Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

import java.util.*;


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>() ; 
        List<Integer> set = new ArrayList<>() ; 
        backtrack(res , 0 , nums , set) ; 
        return res ; 
    }

    public void backtrack(List<List<Integer>> res ,int idx , int[] nums , List<Integer> set ){
        if(idx >= nums.length) res.add(new ArrayList<>(set)) ; 
        else {
            set.add(nums[idx]) ; 
            backtrack(res , idx+1 , nums , set) ; 
            set.remove(set.size()-1) ; 
            backtrack(res , idx+1 , nums , set ) ; 
        }
    }
}