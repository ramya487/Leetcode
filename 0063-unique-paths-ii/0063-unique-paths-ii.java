class Solution {
    public static int recur(int i, int j, int[][] grid, int[][] dp){
        if (i == 0 && j == 0){
            if (grid[i][j] == 1) return 0;
            return 1;
        }
        if (i<0 || j<0) return 0;
        if (grid[i][j] == 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int l = recur(i-1, j, grid, dp);
        int r = recur(i, j-1, grid, dp);
        dp[i][j] = l+r;
        return l+r;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i<obstacleGrid.length; i++){
            for (int j = 0; j<obstacleGrid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return recur(obstacleGrid.length-1, obstacleGrid[0].length-1, obstacleGrid, dp);
    }
}