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
// checking the height of left and right subtrees of all the nodes and
// determining whether acceptable or not
// T- O(n2)
// S- O(h)
class Solution {
    public static int depth(TreeNode node){
        if (node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        return Math.max(l,r)+1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = depth(root.left);
        int r = depth(root.right);
        if (Math.abs(l-r) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
}