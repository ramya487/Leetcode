class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int maxx = Integer.MIN_VALUE;
        int n = nums.length;
        while (right < n){
            if (nums[right] == 0){
                if (count == k){
                    maxx = Math.max(maxx, right-left);
                    if (nums[left] == 0){
                        left++;
                    }else {
                        while (nums[left] != 0){
                            left++;
                        }
                        left++;
                    }
                }else {
                    count++;
                }
            }
            right++;
        }
        maxx = Math.max(maxx, right-left);
        return maxx;
    }
}