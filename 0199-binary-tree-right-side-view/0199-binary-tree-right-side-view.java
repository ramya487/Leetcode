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
 // T- O(N)
 // S- O(H)
 // recursion to avoid the complexity of level order traversal
class Solution {
    public static void recur(TreeNode root, int level, List<Integer> ds){
        if (root == null) return;
        if (ds.size() == level) ds.add(root.val);
        recur(root.right, level+1, ds);
        recur(root.left, level+1, ds);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ds = new ArrayList<Integer>();
        recur(root, 0, ds);
        return ds;
    }
}