class Solution {
    public static void dfs(int[][] image, int i, int j, int origColor, int newColor, int[][] vis){
        if (image[i][j] != origColor || vis[i][j] != 0) return;
        image[i][j] = newColor;
        vis[i][j] = 1;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for (int counter = 0; counter<4; counter++){
            int nr = delrow[counter]+i;
            int nc = delcol[counter]+j;
            if (nr>=0 && nc>=0 && nr<image.length && nc<image[0].length){
                dfs(image, nr, nc, origColor, newColor, vis);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] vis = new int[m][n];
        dfs(image, sr, sc, image[sr][sc], color, vis);
        return image;
    }
}