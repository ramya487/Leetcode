class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            visited[i] = grid[i].clone();
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m-1 || j == 0 || j == n-1) && (visited[i][j] == 1)) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            for (int[] dir : dirs) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (i >= 0 && j >= 0 && i < m && j < n && visited[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = 0;
                }
            }
        }
        int countLands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1) {
                    countLands++;
                }
            }
        }
        return countLands;
    }
}