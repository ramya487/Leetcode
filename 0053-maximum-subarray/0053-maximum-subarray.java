// T- O(n)
// S- O(1)
// kadane's algo - maximum subarray sum
class Solution {
    public int maxSubArray(int[] nums) {
        int summ = 0;
        int maxx = Integer.MIN_VALUE;
        int ansstart = -1;
        int ansend = -1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (summ == 0) start = i;
            int ele = nums[i];
            summ += ele;
            if (summ>maxx){
                maxx = summ;
                ansstart = start;
                ansend = i;
            }
            if (summ < 0)
                summ = 0;
        }
        System.out.println(ansstart+" "+ansend); // to get the one of the sub arrays with maxx sum
        return maxx;
    }
}