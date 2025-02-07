class Solution {
    public static void dfs(List<List<Integer>> adjList, int[] vis, int node){
        vis[node] = 1;
        for (int neighbour: adjList.get(node)){
            if (vis[neighbour] == 0){
                dfs(adjList, vis, neighbour);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if (isConnected[i][j] == 1 && j != i){
                    adjList.get(i).add(j);
                }
            }
        }

        int[] vis = new int[n];
        int p = 0;
        for (int i = 0; i<n; i++){
            if (vis[i] == 0){
                p++;
                dfs(adjList, vis, i);
            }
        }

        return p;
    }
}