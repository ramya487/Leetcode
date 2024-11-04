class Pair{
    int r,c,tm;
    Pair(int r, int c, int tm){
        this.r = r;
        this.c = c;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else if (grid[i][j] == 1) freshCount++;
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int cnt = 0;
        int maxMin = 0;

        while (!q.isEmpty()){
            Pair frnt = q.poll();
            int r = frnt.r;
            int c = frnt.c;
            int tm = frnt.tm;
            maxMin = Math.max(maxMin, tm);
            for (int i = 0; i<4; i++){
                int row = r+delRow[i];
                int col = c+delCol[i];
                if (row>=0 && col>=0 && row<m && col<n && vis[row][col] == 0 && grid[row][col] == 1){
                    q.offer(new Pair(row, col, tm+1));
                    cnt++;
                    vis[row][col] = 2;
                }
            }
        }

        if (freshCount != cnt) return -1;
        return maxMin;
    }
}