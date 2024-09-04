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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()){
            int s = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i<s; i++){
                TreeNode temp = q.poll();
                if (temp == null){
                    l.add(null);
                }else{
                    l.add(temp.val);
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
            }
            ls.add(l);
        }
        for (List<Integer> item: ls){
            for (int i = 0; i<item.size()/2; i++){
                if (item.get(i) != item.get(item.size()-i-1)){
                    return false;
                }
            }
        }
        return true;
    }
}