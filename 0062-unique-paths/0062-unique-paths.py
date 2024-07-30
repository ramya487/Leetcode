# recursion+memoization - dp on grids
class Solution:
    def recur(self, i,j, dp):
        if i == 0 and j == 0:
            return 1
        if i<0 or j<0:
            return 0
        if dp[i][j] != -1:
            return dp[i][j]
        l = self.recur(i-1, j, dp)
        r = self.recur(i,j-1, dp)
        dp[i][j] = l+r
        return l+r
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[-1 for i in range(n)] for i in range(m)]
        return self.recur(m-1, n-1, dp)