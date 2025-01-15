// T- O(n)
// S- O(n)
// prefix sum and hashing
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>(); // psum: frequency
        int summ = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            summ += nums[i];
            if (summ == k)
                ret++;
            int rem = summ-k;
            if (mp.containsKey(rem)) {
                ret += mp.get(rem);
            }
            if (mp.containsKey(summ)) {
                mp.put(summ, mp.get(summ) + 1);
            } else {
                mp.put(summ, 1);
            }
        }
        return ret;
    }
}