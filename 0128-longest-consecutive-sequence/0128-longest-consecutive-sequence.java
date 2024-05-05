class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 1;
        int maxx = 0;
        while (right<nums.length){
            if (nums[right] == nums[left]){
                right++;
                left++;
            }
            else if (nums[right] == nums[left]+1) {
                count++;
                left++;
                right++;
            }else {
                maxx = Math.max(maxx, count);
                left = right;
                right++;
                count = 1;
            }
        }
        maxx = Math.max(maxx,count);
        return maxx;
    }
}