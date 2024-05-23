// T- O(2K)
// S- O(1)
// two pointers
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int summ = 0;
        int n = cardPoints.length;
        int left = 0;
        int right = n-1;
        while (left<k){
            summ+=cardPoints[left];
            left++;
        }
        left--;
        int maxx = Integer.MIN_VALUE;
        maxx = Math.max(maxx, summ);
        while (left >=0){
            summ-=cardPoints[left];
            left--;
            summ+=cardPoints[right];
            right--;
            maxx = Math.max(maxx, summ);
        }
        return maxx;
    }
}