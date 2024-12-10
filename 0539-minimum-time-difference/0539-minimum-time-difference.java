class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] arr = new int[n];
        int min = 1440;
        for(int i=0;i<n;i++){
            String str = timePoints.get(i);
            int h = 0,m = 0;
            h = (int)(str.charAt(0)-'0');
            h = (h*10) + (int)(str.charAt(1)-'0');
            m = (int)(str.charAt(3)-'0');
            m = (m*10) + (int)(str.charAt(4)-'0');
            m += (h*60);
            arr[i] = m;
        }
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i] == arr[i+1]){
                return 0;
            }
            else{
                int a = arr[i+1]-arr[i];
                if(a<min){
                    min = a;
                }
            }
        }
        int m = Math.abs(arr[0]-arr[n-1]);
        int mi = 1440 - m;
        if(m<min){
            min = m;
        }
        if(mi<min){
            min = mi;
        }
        return min;
    }
}