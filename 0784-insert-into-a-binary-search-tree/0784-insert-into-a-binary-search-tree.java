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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;
        TreeNode pptr = null;
        TreeNode ptr = root;
        while (ptr != null){
            pptr = ptr;
            if (ptr.val < val) ptr = ptr.right;
            else ptr = ptr.left;
        }
        if (pptr.val > val) pptr.left = newNode;
        else pptr.right = newNode;
        return root;
    }
}