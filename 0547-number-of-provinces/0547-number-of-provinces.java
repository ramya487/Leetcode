class Solution {
    public static void bfs(int[][] matrix, int[] vis, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;
        while (!q.isEmpty()){
            int front = q.poll();
            for (int i = 0; i<matrix.length; i++){
                if (vis[i] == 0 && matrix[front][i] == 1){
                    q.add(i);
                    vis[i] = 1;
                }
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
                bfs(isConnected, vis, i);
            }
        }

        return p;
    }
}