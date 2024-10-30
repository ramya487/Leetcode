class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ret = new int[n];
        for (int i = 0; i<n; i++){
            ret[i] = nums[i];
        }
        for (int i = 0; i<n; i++){
            nums[(i+k)%n] = ret[i];
        }
    }
}