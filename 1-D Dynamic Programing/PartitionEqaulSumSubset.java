// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.

 

// Constraints:

//     1 <= nums.length <= 200
//     1 <= nums[i] <= 100


import java.util.* ; 

class Solution {
    public boolean canPartition(int[] nums) {
        // Dynamic - Tabulation - TC : O(N*sum(nums))  
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        HashSet<Integer> set = new HashSet<>();
        set.add(0) ;
        for (int i = nums.length - 1; i >= 0; i--) {
            HashSet<Integer> newSums = new HashSet<>();
            newSums.add(nums[i]);
            for (Integer j : set) {
                if (nums[i] + j == target) return true;
                newSums.add(nums[i] + j);
            }
            set.addAll(newSums);
        }
        return false;
    }

    // Brute Force , Backtracking - TC : O(2^N)
    public boolean canPartitionBackTrack(int[] nums) {
        return Partition(nums ,0 , 0 ,0) ; 
    }

    public boolean Partition(int[] nums  , int lsum , int rsum , int i){
        
        if(i==nums.length )
            return (lsum==rsum)?  true : false ; 
        
        return (Partition(nums , lsum+nums[i] , rsum , i+1) || 
                    Partition(nums , lsum , rsum+nums[i] , i+1) );
    }
}