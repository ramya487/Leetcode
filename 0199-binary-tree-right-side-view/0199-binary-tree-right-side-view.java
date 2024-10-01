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
    public static List<Integer> recur(TreeNode root, int level, List<Integer> ds){
        if (root == null) return null;
        if (ds.size() == level) ds.add(root.val);
        recur(root.right, level+1, ds);
        recur(root.left, level+1, ds);
        return ds;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        return recur(root, 0, new ArrayList<Integer>());
    }
}