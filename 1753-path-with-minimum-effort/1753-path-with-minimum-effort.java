class Pair {
    int i,j,effort;
    Pair(int i, int j, int effort){
        this.i = i;
        this.j = j;
        this.effort = effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.effort - y.effort);
        int[][] dist = new int[m][n];
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        pq.add(new Pair(0,0,0));
        dist[0][0] = 0;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while (!pq.isEmpty()){
            Pair frnt = pq.poll();
            int r= frnt.i;
            int c = frnt.j;
            int eff = frnt.effort;
            if (r == m-1 && c == n-1) return eff;
            for (int counter = 0; counter<4; counter++){
                int nrow = r+delrow[counter];
                int ncol = c+delcol[counter];
                if (nrow>=0 && ncol>=0 && nrow<m && ncol<n){
                    int neff = Math.max(eff, Math.abs(heights[nrow][ncol] - heights[r][c]));
                    if (neff<dist[nrow][ncol]){
                        pq.offer(new Pair(nrow, ncol, neff));
                        dist[nrow][ncol] = neff;
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}