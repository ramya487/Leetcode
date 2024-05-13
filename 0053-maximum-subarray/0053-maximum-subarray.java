class Solution {
    public int maxSubArray(int[] nums) {
        int maxx = Integer.MIN_VALUE;
        int summ = 0;
        for (int i = 0; i<nums.length; i++){
            summ+=nums[i];
            maxx = Math.max(maxx, summ);
            if (summ<0){
                summ = 0;
            }
        }
        return maxx;
    }
}