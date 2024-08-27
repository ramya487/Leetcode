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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.add(root);
        while (!st1.isEmpty()){
            TreeNode temp = st1.pop();
            if (temp == null) continue;
            st2.add(temp.val);
            st1.add(temp.left);
            st1.add(temp.right);
        }
        List<Integer> ret = new ArrayList<>();
        while (!st2.isEmpty()){
            ret.add(st2.pop());
        }
        return ret;
    }
}