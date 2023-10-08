# Example 1:


# Input: root = [1,2,2,3,4,4,3]
# Output: true
# Example 2:


# Input: root = [1,2,2,null,3,null,3]
# Output: false
 

# Constraints:

# The number of nodes in the tree is in the range [1, 1000].
# -100 <= Node.val <= 100
 

# Follow up: Could you solve it both recursively and iteratively?

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def sym(p , q)->bool :
            if not p and not q :
                return True 
            if not p or  not q : 
                return False 
            if p.val != q.val :
                return False 
            
            left = sym(p.left , q.right)
            right = sym(p.right , q.left)

            return left and right 
        return sym(root.left , root.right)