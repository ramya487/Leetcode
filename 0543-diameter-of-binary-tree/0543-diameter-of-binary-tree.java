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
 // recursively checking the diameter(sum of depth of left and right subtrees) for every node
 // top down approach

 // T- O(N2)
 // S- O(H) - recursion stack space
class Solution {
    public static int getHeight(TreeNode root){
        if (root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);
        int d = lH+rH;
        int leftD = diameterOfBinaryTree(root.left); // brute force
        int rightD = diameterOfBinaryTree(root.right); // brute force
        return Math.max(d, Math.max(leftD, rightD));
    }
}