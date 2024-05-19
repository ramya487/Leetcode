class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int[] xarr = new int[points.length];
        for (int i = 0; i<points.length; i++){
            xarr[i] = points[i][0];
        }
        Arrays.sort(xarr);
        int x0 = xarr[0];
        int count = 1;
        for (int i = 1; i<xarr.length; i++){
            if (xarr[i] <= x0+w){
                continue;
            }else {
                count++;
                x0 = xarr[i];
            }
        }
        return count;
    }
}