// T- O(n)
// S- O(2n)
// prefix sum
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] psum = new int[n];
        Map<Integer, Integer> mp = new HashMap<>(); // presum:frequency
        int summ = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            summ += nums[i];
            if (summ == k)
                count++;
            int rem = summ - k;
            if (mp.containsKey(rem)) {
                count += mp.get(rem);
            }
            if (!mp.containsKey(summ)) {
                mp.put(summ, 1);
            } else {
                mp.put(summ, mp.get(summ) + 1);
            }
        }
        return count;
    }
}