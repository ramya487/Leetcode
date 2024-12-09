/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    vector<int> solve (TreeNode *root)
    {
        if (root==NULL)
            return {0,0};
        
        vector <int> l = solve(root->left);
        vector <int> r = solve(root->right);
        
        int rob_this = root->val + l[1] + r[1];
        
        int skip_1 = max(l[0] + r[0], l[1] + r[1]);
        int skip_2 = max(l[0] + r[1], r[0] + l[1]);
        
        int skip_this = max(skip_1, skip_2);

        return {rob_this, skip_this};  
    }
    
    int rob(TreeNode* root) 
    {
        vector <int> ans = solve (root);
        return max(ans[0],ans[1]);
    }
};