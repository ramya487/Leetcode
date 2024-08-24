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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        if (node == null) return lst;
        st.push(node);
        node = node.left;
        while (!(node == null && st.isEmpty())){
            if (!(node == null)){
                st.push(node);
                node = node.left;
            }else{
                TreeNode temp = st.pop();
                lst.add(temp.val);
                node = temp.right;
            }
        }
        return lst;
    }
}