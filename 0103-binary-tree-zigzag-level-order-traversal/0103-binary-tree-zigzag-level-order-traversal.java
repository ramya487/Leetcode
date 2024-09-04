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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) return ls;
        q.offer(root);
        while (!q.isEmpty()){
            int s = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i<s; i++){
                TreeNode t = q.poll();
                l.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            ls.add(l);
        }
        for (int i = 0; i<ls.size(); i++){
            if (i%2 != 0) Collections.reverse(ls.get(i));
        }
        return ls;
    }
}