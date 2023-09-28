# You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

# Return the max sliding window.

 

# Example 1:

# Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
# Output: [3,3,5,5,6,7]
# Explanation: 
# Window position                Max
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
#  1 [3  -1  -3] 5  3  6  7       3
#  1  3 [-1  -3  5] 3  6  7       5
#  1  3  -1 [-3  5  3] 6  7       5
#  1  3  -1  -3 [5  3  6] 7       6
#  1  3  -1  -3  5 [3  6  7]      7
# Example 2:

# Input: nums = [1], k = 1
# Output: [1]
 

# Constraints:

# 1 <= nums.length <= 105
# -104 <= nums[i] <= 104
# 1 <= k <= nums.length
import collections

class Solution:
    def maxSlidingWindow(self , nums , k ) -> int :
        res = [ ]
        q = collections.deque()
        l =0
        for r in range(len(nums)):
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            q.append(r)
            
            if l > q[0] :
                q.popleft()
            
            if (r+1 >= k):
                res.append(nums[q[0]])
                l += 1
        return res

    def brute_force_maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        l=0 
        res = []
        for r in range(k, len(nums)+1):
            # print(nums[l:r])
            res.append(max(nums[l:r]))
            l += 1 
        return res 