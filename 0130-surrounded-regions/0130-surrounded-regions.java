class Solution {
    public static void dfs(int i, int j, char[][] board, int[][] vis){
        if (vis[i][j] == 1) return;
        vis[i][j] = 1;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0,1,0,-1};
        int m = board.length;
        int n = board[0].length;
        for (int counter = 0; counter<4; counter++){
            int nr = i + delrow[counter];
            int nc = j + delcol[counter];
            if (nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc] == 'O')
                dfs(nr, nc, board, vis);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];

        for (int i = 0; i<n; i++){
            if (board[0][i] == 'O')
                dfs(0, i, board, vis);
        }
        for (int i = 0; i<n; i++){
            if (board[m-1][i] == 'O')
                dfs(m-1, i, board, vis);
        }
        for (int i = 0; i<m; i++){
            if (board[i][0] == 'O')
                dfs(i, 0, board, vis);
        }
        for (int i = 0; i<m; i++){
            if (board[i][n-1] == 'O')
                dfs(i, n-1, board, vis);
        }

        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}