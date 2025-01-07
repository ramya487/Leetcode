// T- O(n)
// S- O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int minn = prices[0];
        int maxP = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minn) {
                maxP = Math.max(maxP, prices[i] - minn);
            } else {
                minn = prices[i];
            }
        }

        return (maxP == Integer.MIN_VALUE) ? 0 : maxP;
    }
}