// hashmap
// T- O(n)
// S- O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int[] ret = new int[2];
        for (int i = 0; i<n; i++){
            if (mp.containsKey(target-nums[i])){
                ret[0] = i;
                ret[1] = mp.get(target-nums[i]);
                break;
            }
            mp.put(nums[i], i);
        }
        return ret;
    }
}