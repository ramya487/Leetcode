class Solution {
    public static void dfs(int[][] matrix, int[] vis, int node){
        vis[node] = 1;
        for (int i = 0; i<matrix.length; i++){
            if (vis[i] == 0 && matrix[node][i] == 1){
                dfs(matrix, vis, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int p = 0;
        for (int i = 0; i<n; i++){
            if (vis[i] == 0){
                p++;
                dfs(isConnected, vis, i);
            }
        }

        return p;
    }
}