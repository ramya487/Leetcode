class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int l = 0;
        while (l<n && nums[l] != 0) l++;
        int r = l;
        while (r<n && nums[r] == 0) r++;
        while (l<r && r<n){
            if (nums[l] == 0){
                nums[l] = nums[r];
                nums[r] = 0;
                while (r<n && nums[r] == 0) r++;
            }
            l++;
        }
    }
}