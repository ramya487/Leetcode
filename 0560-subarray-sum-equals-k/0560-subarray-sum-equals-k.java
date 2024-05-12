// T - O(N) + O(N2)
// S - O(N)
// brute force
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixarr = new int[nums.length]; // prefix sum array
        int summ = 0;
        for (int i = 0; i<nums.length; i++){
            summ+=nums[i];
            prefixarr[i] = summ;
        }
        int count = 0;
        for (int i = 0; i<prefixarr.length; i++){
            if (prefixarr[i] == k) count++;
            for (int j = i+1; j<prefixarr.length; j++){
                if (prefixarr[j] - prefixarr[i] == k) count++;
            }
        }
        return count;
    }
}