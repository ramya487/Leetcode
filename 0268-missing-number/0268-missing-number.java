// math and logic
//T- O(N)
//S- O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tsum = n*(n+1)/2;
        int osum = 0;
        for (int i = 0; i<n; i++){
            osum+=nums[i];
        }
        return tsum-osum;
    }
}