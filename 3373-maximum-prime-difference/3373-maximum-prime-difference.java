// T- O(N2)
// S- O(1)
class Solution {
    public boolean isPrime(int n){
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int j = 2; j<n; j++){
            if (n%j == 0) return false;
        }
        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int i = 0; i<nums.length; i++){
            if (isPrime(nums[i])) {
                if (left == Integer.MIN_VALUE){
                    left = i;
                    right = i;
                }else{
                right = i;
            }
            }
        }
        return right-left;
    }
}