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
// level order traversal + list comparison
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
        queue.add(p);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp == null){
                ls1.add(null);
            }else{
                ls1.add(temp.val);
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        queue.add(q);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp == null){
                ls2.add(null);
            }else{
                ls2.add(temp.val);
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        if (ls1.equals(ls2)) return true;
        return false;
    }
}