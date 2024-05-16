// T- O(2N)
// S- O(N)
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp = new int[energy.length];
        for (int i = energy.length-1; i>=0; i--){
            int temp;
            if (i+k < energy.length) temp = dp[i+k];
            else temp = 0;
            dp[i] = energy[i] + temp;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<energy.length; i++){
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}