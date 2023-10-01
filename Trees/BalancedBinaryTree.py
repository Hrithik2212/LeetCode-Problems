# Given a binary tree, determine if it is 
# height-balanced
# .

 

# Example 1:


# Input: root = [3,9,20,null,null,15,7]
# Output: true
# Example 2:


# Input: root = [1,2,2,3,3,null,null,4,4]
# Output: false
# Example 3:

# Input: root = []
# Output: true
 

# Constraints:

# The number of nodes in the tree is in the range [0, 5000].
# -104 <= Node.val <= 104

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.result = True 

    def dfs(self  ,root:TreeNode) -> int:
        if not root:
            return 0
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        if abs(left - right) > 1:
            self.result = False 
        return 1+max(left , right)
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.dfs(root)
        return self.result