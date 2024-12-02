class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] memo = new Integer[n][n];
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++)
        {
            min = Math.min(min,helper(memo,0,i,matrix));
        }

        return min;
    }

    public int helper(Integer[][] memo,int x, int y,int[][] matrix)
    {
        int n = matrix.length;
        if(y<0||y>=n) return Integer.MAX_VALUE;  
        if(x>=n) return 0;
        if(memo[x][y]!=null) return memo[x][y];


       
        int min= Math.min(helper(memo,x+1,y+1,matrix),helper(memo,x+1,y,matrix));
        min = Math.min(min,helper(memo,x+1,y-1,matrix));

        return memo[x][y] = min+matrix[x][y];
    }
}