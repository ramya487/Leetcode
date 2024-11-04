class Pair {
    int r,c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                ret[i][j] = image[i][j];
            }
        }

        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(sr,sc));
        int val = image[sr][sc];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0,1,0,-1};

        int[][] vis = new int[m][n];
        vis[sr][sc] = 1;

        while (!q.isEmpty()){
            Pair frnt = q.poll();
            int r = frnt.r;
            int c = frnt.c;
            ret[r][c] = color;
            vis[r][c] = 1;
            for (int i = 0; i<4; i++){
                int row = r+delRow[i];
                int col = c+delCol[i];
                if (row>=0 && col>=0 && row<m && col<n && ret[row][col] == val && vis[row][col] != 1){
                    q.offer(new Pair(row, col));
                }
            }
        }

        return ret;
    }
}