// dfs
// T- O(n)
// S- O(n) (vis array) + O(n) (recur stack space)

class Solution {
    public static boolean dfs(int[][] graph, int[] vis, int color, int node) {
        vis[node] = color;

        for (int neigh: graph[node]){
            if (vis[neigh] == -1){
                if (!dfs(graph, vis, 1-color, neigh)) return false;
            }else if (vis[neigh] == color) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        // note that graph is an adjacency list
        int n = graph.length;
        int[] colorfill = new int[n];
        Arrays.fill(colorfill, -1);

        for (int i = 0; i < n; i++) {
            if (colorfill[i] == -1) {
                if (dfs(graph, colorfill, 0, i) == false)
                    return false;
            }
        }

        return true;
    }
}