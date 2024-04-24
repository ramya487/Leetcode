import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length -2;
        int right = nums.length-1;
        int last = nums.length-1;
        if (left == right){
            return;
        }
        int flag = 0;
        while (left>=0 && flag == 0){
            System.out.println(left+" "+right);
            if (nums[left]>=nums[right]){
                left--;
                right--;
            }else {
                while (nums[last]<=nums[left]){
                    last--;
                }
                int temp = nums[left];
                nums[left] = nums[last];
                nums[last] = temp;
                Arrays.sort(nums, left+1, nums.length);
                flag = 1;
            }
        }
        if (flag == 0){
            Arrays.sort(nums);
        }
    }
}