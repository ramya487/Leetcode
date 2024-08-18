class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i<n; i++){
            if (nums[i] == nums[i-1]+1)
                prefix[i] = prefix[i-1]+1;
            else
                prefix[i] = 1;
        }

        int[] results = new int[n-k+1];

        int l = 0,r = k-1;
        while (r<n){
            if (prefix[r]>=k){
                results[l] = nums[r];
            }else{
                results[l] = -1;
            }
            l++;
            r++;
        }
        return results;
    }
}