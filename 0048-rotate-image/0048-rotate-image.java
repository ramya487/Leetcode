// brute
// T- O(2n2)
// S- O(n2)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ret = new int[n][n];
        for (int r = 0; r<n; r++){
            for (int c = 0; c<n; c++){
                ret[r][c] = matrix[r][c];
            }
        }
        for (int r = 0; r<n; r++){
            for (int c = 0; c<n; c++){
                matrix[c][n-r-1] = ret[r][c];
            }
        }
    }
}