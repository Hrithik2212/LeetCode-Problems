// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
 

// Constraints:

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>() ; 
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        backTrack(res , curr , numbers) ; 
        return res ; 
    }

    public void backTrack(List<List<Integer>> res , List<Integer> curr , List<Integer> nums ){
        if(nums.size() == 0 ) {
            res.add(new ArrayList(curr));
            return ; 
        }
        for(int i=0;i<nums.size();i++){
            curr.add(nums.get(i));
            List<Integer> remainingNums = new ArrayList<>(nums);
            remainingNums.remove(i);
            backTrack(res, curr, remainingNums);
            curr.remove(curr.size() - 1);
        }
    }
}