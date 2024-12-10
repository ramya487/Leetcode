class Solution {
    public int recursion(int index, int[] arr, int target) {
        if (index == 0) return target % arr[0] == 0 ? 1 : 0;

        int notTake = recursion(index - 1, arr, target);
        int take = 0;
        if (arr[index] <= target)
            take = recursion(index, arr, target - arr[index]);

        return take + notTake;
    }

    public int memoization(int index, int[] arr, int target, int[][] dp) {
        if (index == 0) return target % arr[0] == 0 ? 1 : 0;

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = memoization(index - 1, arr, target, dp);
        int take = 0;
        if (arr[index] <= target)
            take = memoization(index, arr, target - arr[index], dp);

        return dp[index][target] = take + notTake;
    }

    public long tabulation(int[] arr, int target) {
        int n = arr.length;
        long[][] dp = new long[n][target + 1];

        for (int T = 0; T <= target; T++)
            dp[0][T] = (T % arr[0] == 0) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            for (int T = 0; T <= target; T++) {
                long notTake = dp[i - 1][T];
                long take = (arr[i] <= T) ? dp[i][T - arr[i]] : 0;
                dp[i][T] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }

    public long spaceOptimization(int[] arr, int target) {
        int n = arr.length;
        long[] prev = new long[target + 1];
        long[] cur = new long[target + 1];

        for (int T = 0; T <= target; T++)
            prev[T] = (T % arr[0] == 0) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            for (int T = 0; T <= target; T++) {
                long notTake = prev[T];
                long take = (arr[i] <= T) ? cur[T - arr[i]] : 0;
                cur[T] = take + notTake;
            }
            prev = cur.clone();
        }

        return prev[target];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int[][] dp = new int[n][amount + 1];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return memoization(n - 1, coins, amount, dp);

        // return tabulation(coins, amount);
        return (int) spaceOptimization(coins, amount);
    }
}