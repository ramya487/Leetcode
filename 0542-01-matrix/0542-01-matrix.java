class Node {
    int i, j, d;

    Node(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.d = d;

    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Node node = q.poll();
            int r = node.i;
            int c = node.j;
            int dt = node.d;
            dist[r][c] = dt;

            for (int counter = 0; counter < 4; counter++) {
                int nr = r + delrow[counter];
                int nc = c + delcol[counter];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && vis[nr][nc] == 0 && mat[nr][nc] == 1) {
                    q.offer(new Node(nr, nc, dt + 1));
                    vis[nr][nc] = 1;
                }
            }
        }

        return dist;
    }
}