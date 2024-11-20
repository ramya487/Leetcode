// T- O(N)
// S- O(1)
// ptr concept and logic
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0;
        int n = nums.length;
        int maxx = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++){
            if (nums[i] == 0) {
                maxx = Math.max(c, maxx);
                c = 0;
            }else{
                c++;
            }
        }
        maxx = Math.max(c, maxx);
        return maxx;
    }
}