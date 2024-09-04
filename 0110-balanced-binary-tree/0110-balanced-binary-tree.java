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
    public static int getHeight(TreeNode node){
        if (node == null) return 0;
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        int abs = Math.abs(l-r);
        if (abs<=1 && isBalanced(root.left) && isBalanced(root.right)) return true;
        return false;
    }
}