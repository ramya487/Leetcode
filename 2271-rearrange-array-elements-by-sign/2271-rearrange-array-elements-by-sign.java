class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;
        while (pos < nums.length && neg < nums.length){
            if (nums[pos] < 0){
                int t = pos;
                int ppos = nums[pos];
                int temp_var;
                while (nums[t] < 0){
                    temp_var = nums[t];
                    nums[t] = ppos;
                    ppos = temp_var;
                    t++;
                }
                temp_var = nums[t];
                nums[t] = ppos;
                nums[pos] = temp_var;
            }
            if (nums[neg] >= 0){
                int t = neg;
                int ppos = nums[neg];
                int temp_var;
                while (nums[t] >= 0){
                    temp_var = nums[t];
                    nums[t] = ppos;
                    ppos = temp_var;
                    t++;
                }
                temp_var = nums[t];
                nums[t] = ppos;
                nums[neg] = temp_var;
            }
            pos+=2;
        neg+=2;
        }
        return nums;
    }
    
}