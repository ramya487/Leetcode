class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        int n = result.size();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++){
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        int j;
        int initial = answer[0];
        int count = 0;
        for (j = 0; j < n; j++){
            if (answer[j] == initial){
                count++;
            }
            else {
                break;
            }
        }
        if (j == n){
            return -1;
        }
        return answer[j];
    }
    public void traversal(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}