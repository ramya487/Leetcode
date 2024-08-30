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
    public static int preOrder(TreeNode root, int count){
        if (root == null) return count;
        count++;
        int l = preOrder(root.left, count);
        int r = preOrder(root.right, count);
        return Math.max(l,r);
    }

    public int maxDepth(TreeNode root) {
        return preOrder(root, 0);
    }
}