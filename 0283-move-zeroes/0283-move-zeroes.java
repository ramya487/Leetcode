// T- O(N) + O(no of zeros)
// S- O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0,j = 0;
        while (j<n){
            if (nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i<n){
            nums[i] = 0;
            i++;
        }
    }
}