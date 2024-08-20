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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) return ls;
        q.add(root);
        while (!q.isEmpty()){
            int s = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i<s; i++){
                TreeNode f = q.remove();
                temp.add(f.val);
                if (f.left != null) q.add(f.left);
                if (f.right != null) q.add(f.right);
            }
            ls.add(temp);
        }
        return ls;
    }
}