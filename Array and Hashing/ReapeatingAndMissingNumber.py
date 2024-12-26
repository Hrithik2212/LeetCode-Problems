# Problem statement
# You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’. Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.



# Your task is to find ‘P’ and ‘Q’ and return them respectively.



# Detailed explanation ( Input/output format, Notes, Images )
# Constraints:
# 2 <= N <= 5 * 10^4
# 1 <= data <= N

# Where ‘N’ is the size of the array and ‘data’ denotes the value of the elements of the array. 
# Sample Input 1:
# 4
# 1 2 3 2
# Sample Output 1:
# 2 4
# Explanation Of Sample Input 1:
# Input: ‘N’ = 4
# ‘A’ = [1, 2, 3, 2]
# Output: {2, 4} - The integer appearing twice is ‘2’, and the integer missing is ‘4’.
# Sample Input 2:
# 3
# 1 2 1
# Sample Output 2:
# 1 3

def findMissingRepeatingNumbers(a: [int]) -> [int]:
    # Write your code here 
    # Try to submit your code in O(n) Time complexity.
    curr_sum = sum(a)
    org_sum = (len(a) * (len(a)+1)) / 2
    curr_sum2 = sum([n**2 for n in a])
    org_sum2 = (org_sum * (2*len(a)+1) ) / 3
    sum_diff = org_sum - curr_sum
    sum_diff2 = org_sum2 - curr_sum2 
    sum_add = sum_diff2 / sum_diff
    two_x = sum_diff + sum_add 
    x = two_x / 2
    y = sum_add - x 
    return [int(y) , int(x)]