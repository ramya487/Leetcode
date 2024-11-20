class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int peak = -1;
        for (int i = 1; i<n; i++){
            if (arr[i-1]<arr[i] && arr[i+1]<arr[i]){
                peak = i;
                break;
            }
        }
        return peak;
    }
}