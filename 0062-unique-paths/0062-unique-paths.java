// T- O(n*m)
// S- O(n*m)
// tabulation + dp array
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    int l = 0, r = 0;
                    if (i != 0)
                        l += dp[i - 1][j];
                    if (j != 0)
                        r += dp[i][j - 1];
                    dp[i][j] = l+r;
                }
            }
        }
        return dp[m-1][n-1];
    }
}