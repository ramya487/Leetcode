class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxx = Integer.MIN_VALUE;
        int li = 1;
        int ld = 1;
        int i = 0;
        while(i<nums.length-1){
            if (nums[i] < nums[i+1]){
                li++;
            }else {
                maxx = Math.max(li,maxx);
                li = 1;
            }
            if (nums[i] > nums[i+1]){
                ld++;
            }else {
                maxx = Math.max(ld, maxx);
                ld = 1;
            }
            i++;
        }
        maxx = Math.max(ld, maxx);
        maxx = Math.max(li, maxx);
        return maxx;
    }
}