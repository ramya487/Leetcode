class Solution {
    private static TreeNode out;

    private static boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean a = helper(root.left, p, q);
        boolean b = helper(root.right, p, q);

        if (root.val == p.val || root.val == q.val) {
            if (a || b)
                out = root;
            return true;
        }

        if (a && b)
            out = root;

        return a || b;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);

        return out;
    }
}