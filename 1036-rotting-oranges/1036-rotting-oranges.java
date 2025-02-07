class Pair {
    int i,j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if (grid[i][j] == 2){
                    q.offer(new Pair(i,j));
                }
                if (grid[i][j] != 0){
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        int minn = -1;
        int visf = 0;
        int cnt = 0;

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        while (!q.isEmpty()){
            int size = q.size();
            minn++;
            cnt+=size;
            for (int counter = 0; counter<size; counter++){
                Pair cell = q.poll();
                int i = cell.i;
                int j = cell.j;
                for (int c = 0; c<4; c++){
                    int nr = delrow[c]+i;
                    int nc = delcol[c]+j;
                    if (nr<0 || nc < 0 || nr>= m || nc >= n || grid[nr][nc] == 0 || grid[nr][nc] == 2) continue;
                    grid[nr][nc] = 2;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return (fresh == cnt) ? minn : -1;
    }
}