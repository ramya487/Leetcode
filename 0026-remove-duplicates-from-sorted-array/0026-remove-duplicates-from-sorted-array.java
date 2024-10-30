// T- O(N)
// S- O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int count = 0;
        int l = 0, r = 1;
        while (r<n){
            if (nums[l]<nums[r]){
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l+1;   
    }
}