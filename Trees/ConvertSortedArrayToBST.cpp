// Given an integer array nums where the elements are sorted in ascending order, convert it to a 
// height-balanced
//  binary search tree.

 

// Example 1:


// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:


// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in a strictly increasing order.

#include <vector.h>


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if(nums.size() == 0 ) return NULL ; 
        if(nums.size() == 1 ) return new TreeNode(nums[0]) ;
        int l = 0 , r = nums.size() ; 
        int mid = l + ( r-l) / 2;
        TreeNode* node = new TreeNode(nums[mid]);
        vector<int> leftsub(nums.begin() , nums.begin() + mid);
        vector<int> rightsub(nums.begin()+mid+1 , nums.end());
        node->left = sortedArrayToBST(leftsub);
        node->right = sortedArrayToBST(rightsub) ;
        return node ; 
    }
};