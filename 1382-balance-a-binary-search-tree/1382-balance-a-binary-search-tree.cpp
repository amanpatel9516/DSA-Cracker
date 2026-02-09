class Solution {
public:
    // Step 1: Inorder traversal to get sorted values
    void inorder(TreeNode* root, vector<int>& vals) {
        if (!root) return;
        inorder(root->left, vals);
        vals.push_back(root->val);
        inorder(root->right, vals);
    }

    // Step 2: Build balanced BST from sorted array
    TreeNode* buildBST(vector<int>& vals, int left, int right) {
        if (left > right) return nullptr;

        int mid = (left + right) / 2;
        TreeNode* root = new TreeNode(vals[mid]);

        root->left = buildBST(vals, left, mid - 1);
        root->right = buildBST(vals, mid + 1, right);

        return root;
    }

    TreeNode* balanceBST(TreeNode* root) {
        vector<int> vals;

        // Get sorted values
        inorder(root, vals);

        // Build balanced BST
        return buildBST(vals, 0, vals.size() - 1);
    }
};
