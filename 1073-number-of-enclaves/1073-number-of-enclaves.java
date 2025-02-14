// dfs
// T- O(n*m)
// S- O(n*m)

class Solution {
    public static void dfs(int i, int j, int[][] grid, int[][] vis){
        if (vis[i][j] == 1) return;
        vis[i][j] = 1;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int m = grid.length;
        int n = grid[0].length;
        for (int counter = 0; counter<4; counter++){
            int nr = i+delrow[counter];
            int nc = j+delcol[counter];
            if (nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc] == 1)
                dfs(nr, nc, grid, vis);  
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        for (int i = 0; i<n; i++){
            if (grid[0][i] == 1)
                dfs(0, i, grid, vis);
        }
        for (int i = 0; i<n; i++){
            if (grid[m-1][i] == 1)
                dfs(m-1, i, grid, vis);
        }
        for (int i = 0; i<m; i++){
            if (grid[i][0] == 1)
                dfs(i, 0,grid, vis);
        }
        for (int i = 0; i<m; i++){
            if (grid[i][n-1] == 1)
                dfs(i, n-1, grid, vis);
        }

        int lcells = 0;

        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (vis[i][j] == 0 && grid[i][j] == 1)
                    lcells++;
            }
        }

        System.out.println(Arrays.deepToString(vis));
        return lcells;
    }
}