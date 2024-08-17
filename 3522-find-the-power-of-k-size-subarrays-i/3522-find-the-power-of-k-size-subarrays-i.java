class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if ( k ==1 )return nums;
        int[] results = new int[n-k+1];
        int left = 0;
        int right = 0;
        Arrays.fill(results, -1);
        while (right<n-1){
            if (nums[right+1] == nums[right]+1){
                right++;
                if (right-left+1 == k){
                    results[left] = nums[right];
                    left++;
                }
            }else{
                right++;
                left = right;
            }
        }
        return results;
    }
}