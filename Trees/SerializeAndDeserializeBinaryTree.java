// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

// Example 1:


// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]
// Example 2:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000


public class TreeNode {
    int val ;
    TreeNode left ; 
    TreeNode right ;
    TreeNode(int x){
        this.val = x ; 
    }
    TreeNode(int x , TreeNode left , TreeNode right){
        this.val = x ; 
        this.left = left ; 
        this.right = right ; 
    }
}
public class Codec {
    public String serializeUtil(TreeNode root , String res){
        if(root==null) 
            return res+"N," ; 
        res = res + root.val + ","; 
        res = serializeUtil(root.left , res) ; 
        res = serializeUtil(root.right , res) ; 
        return res ; 
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res= "" ;
        return serializeUtil(root,res) ; 
        
    }

    int i = 0 ; 
    String[] values ; 

    public TreeNode deserializeUtil() {
        if (this.values[this.i].equals("N")) {
            this.i++;
            return null;  // Handle null node
        }

        // Only convert to integer if it's not "N"
        TreeNode node = new TreeNode(Integer.parseInt(values[this.i]));
        this.i++;
        node.left = deserializeUtil();
        node.right = deserializeUtil();
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.values = data.split(",") ;
        return deserializeUtil() ; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));