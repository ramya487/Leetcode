// T- O(nlogn) + O(n/2)
class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        if (n == 1){
            return nums[0] < k ? k-nums[0] : nums[0] - k;
        }
        Arrays.sort(nums);
        int med = nums[n/2];
        long count = 0;
        if (med == k) return count;
        else if (med < k) {
            for (int i = n/2; i<nums.length; i++){
                if (nums[i] < k){
                    count+=k-nums[i];
                }
            }
        }else {
            for (int i = 0; i<=n/2; i++){
                if (nums[i] > k){
                    count+=nums[i]-k;
                }
            }
        }
        return count;
    }
}