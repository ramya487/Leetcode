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
 // level order traversal - iteration
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int h = 0;
        if (root == null) return h;
        q.offer(root);
        while (!q.isEmpty()){
            int s = q.size();
            h++;
            for (int i = 0; i<s; i++){
                TreeNode p = q.poll();
                if (p.left != null) q.offer(p.left);
                if (p.right != null) q.offer(p.right);
            }
        }
        return h;
    }
}