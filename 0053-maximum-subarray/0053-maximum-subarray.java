// T- O(N)
// S- O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxx = Integer.MIN_VALUE;
        int summ = 0;
        // int[] ind = new int[2];
        // ind[0] = 0;
        // int start = 0;
        for (int i = 0; i<nums.length; i++){
            summ+=nums[i];
            if (summ > maxx){
                // ind[1] = i;
                maxx = summ;
                // ind[0] = start;
            }
            // maxx = Math.max(maxx, summ);
            if (summ<0){
                summ = 0;
                // start = i+1;
            }
        }
        // System.out.println(Arrays.toString(ind));
        return maxx;
    }
}