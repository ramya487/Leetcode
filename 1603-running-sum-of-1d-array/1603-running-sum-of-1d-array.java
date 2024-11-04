// T- O(N)
// S- O(N) - for the running sum array
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int summ = 0;
        for (int i = 0; i<n; i++){
            summ+=nums[i];
            ret[i] = summ;
        }
        return ret;
    }
}