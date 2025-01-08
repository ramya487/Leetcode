// T- O(n)
// S- O(1)
// kadane's algo - maximum subarray sum
class Solution {
    public int maxSubArray(int[] nums) {
        int summ = 0;
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            summ += ele;
            maxx = Math.max(maxx, summ);
            if (summ < 0)
                summ = 0;
        }
        return maxx;
    }
}