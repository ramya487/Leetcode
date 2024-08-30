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
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        q.offer(root);
        while (!q.isEmpty()){
            int s = q.size();
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i<s; i++){
                TreeNode p = q.poll();
                ls.add(p.val);
                if (p.left != null)
                    q.offer(p.left);
                if (p.right != null)
                    q.offer(p.right);  
            }
            ret.add(ls);
        }
        return ret;
    }
}