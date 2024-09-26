/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Tuple {
    TreeNode node;
    int col;
    int row;

    Tuple(TreeNode node, int col, int row){
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        Tuple temp = new Tuple(root, 0, 0);
        q.add(temp);

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            if (!mp.containsKey(t.col)) {
                PriorityQueue<Integer> value = new PriorityQueue<>();
                value.add(t.node.val);
                Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
                map.put(t.row, value);
                mp.put(t.col, map);
            } else {
                Map<Integer, PriorityQueue<Integer>> map = mp.get(t.col);
                if (!map.containsKey(t.row)) {
                    PriorityQueue<Integer> value = new PriorityQueue<>();
                    value.add(t.node.val);
                    map.put(t.row, value);
                    mp.put(t.col, map);
                } else {
                    PriorityQueue<Integer> value = map.get(t.row);
                    value.add(t.node.val);
                    map.put(t.row, value);
                    mp.put(t.col, map);
                }
            }
            if (t.node.left != null) {
                Tuple a = new Tuple(t.node.left, t.col - 1, t.row + 1);
                q.add(a);
            }
            if (t.node.right != null) {
                Tuple a = new Tuple(t.node.right, t.col + 1, t.row + 1);
                q.add(a);
            }
        }

        for (Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> item : mp.entrySet()) {
            List<Integer> ls = new ArrayList<>();
            Map<Integer, PriorityQueue<Integer>> m = item.getValue();
            for (Map.Entry<Integer, PriorityQueue<Integer>> mpp : m.entrySet()) {
                PriorityQueue<Integer> queue = mpp.getValue();
                while (!queue.isEmpty()) {
                    ls.add(queue.poll());
                }
            }
            ret.add(ls);
        }

        return ret;

    }
}