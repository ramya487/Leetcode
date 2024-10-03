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
// recursion - brute force
// T- O(N)
// S- O(H): recursion stack space

class Solution {
    public static boolean util(TreeNode left, TreeNode right){
        if (left == null || right == null) return left == right;

        return left.val == right.val && util(left.left, right.right) && util(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return util(root.left, root.right);
    }
}