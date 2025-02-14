// bfs
// T- O(n*m)
// S- O(n*m)

class Pair {
    int i,j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public static void bfs(int i, int j, char[][] board, int[][] vis){
        if (vis[i][j] == 1) return;
        vis[i][j] = 1;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0,1,0,-1};
        int m = board.length;
        int n = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        while (!q.isEmpty()){
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            for (int counter = 0; counter <4; counter++){
                int nr = r + delrow[counter];
                int nc = c + delcol[counter];
                if (nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc] == 'O' && vis[nr][nc] == 0){
                    q.offer(new Pair(nr, nc));
                    vis[nr][nc] = 1;
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];

        for (int i = 0; i<n; i++){
            if (board[0][i] == 'O')
                bfs(0, i, board, vis);
        }
        for (int i = 0; i<n; i++){
            if (board[m-1][i] == 'O')
                bfs(m-1, i, board, vis);
        }
        for (int i = 0; i<m; i++){
            if (board[i][0] == 'O')
                bfs(i, 0, board, vis);
        }
        for (int i = 0; i<m; i++){
            if (board[i][n-1] == 'O')
                bfs(i, n-1, board, vis);
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