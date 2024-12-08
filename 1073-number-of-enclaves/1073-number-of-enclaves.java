// graph - adj.mat - bfs
class Tuple{
    int i,j;
    Tuple(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        Queue<Tuple> q = new LinkedList<>();
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (i == 0 || j == 0 || i == m-1 || j == n-1){
                    if (grid[i][j] == 1){
                        q.offer(new Tuple(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        while (!q.isEmpty()){
            Tuple node = q.poll();
            for (int counter = 0; counter<4; counter++){
                int nr = node.i+delRow[counter];
                int nc = node.j+delCol[counter];
                if (nr>=0 && nr<vis.length && nc>=0 && nc<vis[0].length && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                    q.offer(new Tuple(nr, nc));
                    vis[nr][nc] = 1;
                }
            }
        }

        int landsNotVisited = 0;
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 1 && vis[i][j] == 0) landsNotVisited++;
            }
        }
        return landsNotVisited;
    }
}