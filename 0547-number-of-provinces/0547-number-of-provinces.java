// T- O(N2) + O(N) + 

class Solution {
    public static List<List<Integer>> createAdjList(int[][] matrix){
        int n = matrix.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if (matrix[i][j] == 1 && j != i) adjList.get(i).add(j);
            }
        }

        return adjList;
    }

    public static void dfs(List<List<Integer>> adjList, int[] vis, Integer node){
        vis[node] = 1;
        for (Integer neighbour: adjList.get(node)){
            if (vis[neighbour] == 0) dfs(adjList, vis, neighbour);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = createAdjList(isConnected);
        int provinces = 0;
        int n = isConnected.length;
        int[] vis = new int[n];
        for (int i = 0; i<n; i++){
            if (vis[i] == 0){
                provinces++;
                dfs(adjList, vis, i);
            }
        }
        return provinces;
    }
}