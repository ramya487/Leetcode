class Solution {
    public static void dfs(int i, int j, int[] delrow, int[] delcol, int[][] vis, char[][] mat){
        vis[i][j] = 1;
        for (int counter = 0; counter<4; counter++){
            int nr = i+delrow[counter];
            int nc = j+delcol[counter];
            if (nr>=0 && nr<vis.length && nc>=0 && nc<vis[0].length && mat[nr][nc] == 'O' && vis[nr][nc] != 1){
                dfs(nr, nc, delrow, delcol, vis, mat);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for (int i = 0; i<m; i++){
            if (board[i][0] == 'O') dfs(i, 0, delrow, delcol, vis, board);
            if (board[i][n-1] == 'O') dfs(i, n-1, delrow, delcol, vis, board);
        }
        for (int i = 0; i<n; i++){
            if (board[0][i] == 'O') dfs(0, i, delrow, delcol, vis, board);
            if (board[m-1][i] == 'O') dfs(m-1, i, delrow, delcol, vis, board);
        }
        System.out.println(Arrays.deepToString(vis));
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (vis[i][j] != 1) board[i][j] = 'X';
            }
        }
    }
}