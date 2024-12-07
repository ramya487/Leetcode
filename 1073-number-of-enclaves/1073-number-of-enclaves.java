// graph - dfs
class Solution {
    public static void dfs(int i, int j, int[][] vis, int[] delrow, int[] delcol, int[][] mat){
        vis[i][j] = 1;
        for (int counter = 0; counter<4; counter++){
            int nr = i+delrow[counter];
            int nc = j+delcol[counter];
            if (nr>=0 && nr<vis.length && nc>=0 && nc<vis[0].length && vis[nr][nc] != 1 && mat[nr][nc] == 1){
                dfs(nr,nc, vis, delrow, delcol, mat);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for (int i = 0; i<m; i++){
            if (grid[i][0] == 1) dfs(i, 0, vis, delrow, delcol, grid);
            if (grid[i][n-1] == 1) dfs(i, n-1, vis, delrow, delcol, grid);
        }
        for (int i = 0; i<n; i++){
            if (grid[0][i] == 1) dfs(0, i, vis, delrow, delcol, grid);
            if (grid[m-1][i] == 1) dfs(m-1, i, vis, delrow, delcol, grid);
        }
        int c = 0;
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (vis[i][j] == 0 && grid[i][j] == 1) c++;
            }
        }
        
        return c;
    }
}