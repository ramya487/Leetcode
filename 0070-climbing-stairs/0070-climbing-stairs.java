class Solution {
    public static int noOfWays(int n, int[] dp){
        if (n  == 0 || n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        int l = noOfWays(n-1, dp);
        int r = noOfWays(n-2, dp);
        int tot = l+r;
        dp[n] = tot;
        return tot;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return noOfWays(n, dp);
    }
}