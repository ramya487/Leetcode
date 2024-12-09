class BSTIterator {
public:
    vector<int> arr = {-1}; //dummy element to take care of indexing
    int idx;

    void dfs (TreeNode* root) { 
//simple inorder traversal & storing the elements in the array
        if (!root) return;
        dfs(root->left);
        arr.push_back(root->val);
        dfs(root->right);
    }

    BSTIterator(TreeNode* root) {
        dfs (root);
        idx = 0;
    }
    
    int next() {
        if (hasNext()) {
            idx++;
            return arr[idx];
        }
        return -1;
    }
    
    bool hasNext() {
        return (idx+1 < arr.size());
    }
};