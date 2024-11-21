// hashmap
// T- O(n)
// S- O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ret = new int[2];
        for (int i = 0; i<nums.length; i++){
            int rem = target-nums[i];
            if (mp.containsKey(rem)){
                ret[0] = i;
                ret[1] = mp.get(rem);
                break;
            }
            mp.put(nums[i], i);
        }
        return ret;
    }
}