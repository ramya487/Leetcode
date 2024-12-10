class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) 
            return nums[nums.length-1];
        return sol(nums,0,nums.length-1);
    }

    public int sol(int[] nums, int l, int r){
        int mid = l + (r-l)/2;
        if(r>=l && mid!=0 && mid != nums.length-1){
            if(nums[mid-1]!=nums[mid] && nums[mid+1]!=nums[mid]) 
                return nums[mid];
            else if((nums[mid]==nums[mid-1] && mid%2==0)|| 
                    (nums[mid]==nums[mid+1] && mid%2==1))
                return sol(nums, l, mid-1);
            else 
                return sol(nums, mid+1, r);
        }
        return -1;
        
    }
}