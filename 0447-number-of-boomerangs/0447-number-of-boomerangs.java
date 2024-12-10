class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            Map<Double,Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                double dist = getDist(points[i][0],points[j][0],points[i][1],points[j][1]);
                map.put(dist,map.getOrDefault(dist,0)+1);
            }
            for(int val : map.values())
                ans += val * (val - 1);
        }
        return ans;
    }
    private static double getDist(int x1,int x2,int y1,int y2){
        double x = Math.pow(x1-x2,2);
        double y = Math.pow(y1-y2,2);
        return Math.sqrt(x+y);
    }
}