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

// brute force
// recursively checking whether every node in the tree is balanced
// isBalanced function does it
// getHeight merely gets the depth of that particular subtree
// T- O(N2)
// S- O(h) - recursive stack space - height of the tree
class Solution {
    public static int getHeight(TreeNode root){
        if (root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.max(l,r)+1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if (Math.abs(l-r)<=1 && isBalanced(root.left) && isBalanced(root.right)) return true;
        return false;
    }
}