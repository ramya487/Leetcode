// T- O(N)
// S- O(1)
// two pointers
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int left = 0, right = 1;
        int n = nums.length;
        if (n == 1) return true;
        while (left < n && right < n){
            if (nums[left]%2 == 0 && nums[right]%2 != 0 || nums[left]%2 != 0 && nums[right]%2 == 0) {
                left++;
                right++;
            }else{
                return false;
            }
        }
        return true;
    }
}