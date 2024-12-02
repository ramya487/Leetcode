class Solution {
    int m;
    int n;

    public int numEnclaves(int[][] grid) {
        // Start dfs from the land at the edges
        m = grid.length;
        n = grid[0].length;

        // First row
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, grid);
            }
        }
        // Last row
        for (int i = 0; i < n; i++) {
            if (grid[m - 1][i] == 1) {
                dfs(m - 1, i, grid);
            }
        }
        // First column
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
        }
        // Last column
        for (int i = 0; i < m; i++) {
            if (grid[i][n - 1] == 1) {
                dfs(i, n - 1, grid);
            }
        }

        int res = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                res += grid[x][y];
            }
        }

        return res;
    }

    private void dfs(int x, int y, int[][] grid) {
        // Out of bound
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        // Not a land or visited
        if (grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;

        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
    }
}