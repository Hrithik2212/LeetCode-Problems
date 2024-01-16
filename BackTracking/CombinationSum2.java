// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
 

// Constraints:

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

import java.util.* ; 

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates) ; 
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> curr = new ArrayList<>() ; 
        backTrack(res ,curr , target , candidates ,0) ; 
        return res ; 
    }

    public void backTrack(List<List<Integer>> res , List<Integer> curr , int target , int nums[] , int idx){
        if(target==0) {
            res.add(new ArrayList(curr)); 
            return ;  
        }
        else if (target < 0 || idx >= nums.length) return ; 
        
        curr.add(nums[idx]) ; 
        backTrack(res , curr , target-nums[idx] , nums ,idx+1) ; 
        curr.remove(curr.size()-1) ; 
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]) idx++ ; 
        backTrack(res , curr , target , nums, idx+1) ; 
    }
}