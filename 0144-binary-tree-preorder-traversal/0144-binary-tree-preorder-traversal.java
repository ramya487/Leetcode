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
    public static List<Integer> preorderRecur(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode valNode = st.pop();
            if (valNode == null) continue;
            preorder.add(valNode.val);
            st.push(valNode.right);
            st.push(valNode.left);
        }
        return preorder;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = preorderRecur(root);
        return ls;
    }
}