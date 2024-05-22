// T- O(2N)
// S- O(1)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tot = 0;
        int minn = Integer.MAX_VALUE;
        int summ = 0;
        int n = cardPoints.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        int bound = n-k-1;
        for (int i = 0; i<n; i++) tot+=cardPoints[i];
        if (n == k) return tot;
        while (right< n){
            if (right-left != bound){
                summ+=cardPoints[right];
                right++;
                continue;
            }else {
                summ+=cardPoints[right];
                if (summ < minn){
                    minn = summ;
                    ans= tot-minn;
                }
            }
            summ-=cardPoints[left];
            left++;
            right++;
        }
        return ans;
    }
}