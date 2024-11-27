// T- O(n*m)
// S- O(n*m)
// dfs - matrix
class Solution {
    public static void dfs(int r, int c, int[][] image, int[][] ret, int color, int prevcolor, int[] delrow, int[] delcol){
        ret[r][c] = color;
        for (int i = 0; i<4; i++){
            int nr = r+delrow[i];
            int nc = c+delcol[i];
            if (nr>=0 && nc>=0 && nr < image.length && nc < image[0].length && image[nr][nc] == prevcolor && ret[nr][nc] != color){
                dfs(nr,nc,image,ret, color, prevcolor, delrow, delcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int[][] ret = image;
        // System.out.println(Arrays.deepToString(ret));
        int prevcolor = image[sr][sc];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        dfs(sr,sc,image,ret, color, prevcolor, delrow, delcol);
        return ret;
    }
}