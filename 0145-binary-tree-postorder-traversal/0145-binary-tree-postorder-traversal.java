/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void postorder(TreeNode root, List<Integer> ls){
        if (root == null) return;
        postorder(root.left, ls);
        postorder(root.right, ls);
        ls.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        postorder(root, ls);
        return ls;
    }
}