/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 * };
 */

class Solution {
public:

    int dfs(TreeNode* root, int curr) {
        if(!root) return 0;

        // build binary number
        curr = (curr << 1) | root->val;

        // if leaf node
        if(!root->left && !root->right)
            return curr;

        // sum of left + right paths
        return dfs(root->left, curr) +
               dfs(root->right, curr);
    }

    int sumRootToLeaf(TreeNode* root) {
        return dfs(root, 0);
    }
};