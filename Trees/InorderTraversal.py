# Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

# Example 1:


# Input: root = [1,null,2,3]
# Output: [1,3,2]
# Example 2:

# Input: root = []
# Output: []
# Example 3:

# Input: root = [1]
# Output: [1]
 

# Constraints:

# The number of nodes in the tree is in the range [0, 100].
# -100 <= Node.val <= 100
 

# Follow up: Recursive solution is trivial, could you do it iteratively?

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = [ ]
        def dfs(root):
            if not root : 
                return 
            dfs(root.left)
            res.append(root.val)
            dfs(root.right)
        dfs(root)
        return res
    def IterativeInorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # Iterative dfs 
        res = []
        stack = []
        curr = root 
        while curr or stack :
            while curr: 
                stack.append(curr)
                curr = curr.left 
            curr = stack.pop()
            res.append(curr.val)
            curr = curr.right 
        return res 