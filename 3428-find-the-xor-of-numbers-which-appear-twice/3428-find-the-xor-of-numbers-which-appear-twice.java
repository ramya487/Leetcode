class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int xor = 0;
        int n = nums.length;
        while (i<n-1){
            if (nums[i] == nums[i+1]){
                xor= xor^nums[i];
                i+=2;
            }else {
                i++;
            }
        }
        return xor;
    }
}