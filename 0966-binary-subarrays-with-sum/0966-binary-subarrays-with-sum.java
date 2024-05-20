// T- O(N)
// S- O(N)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // sum:count
        int summ = 0;
        int count = 0;
        for (int i = 0; i<nums.length; i++){
            summ+=nums[i];
            int diff = summ - goal;
            if (map.containsKey(diff)){
                count+=map.get(diff);
            }
            if (!(map.containsKey(summ))){
                map.put(summ, 1);
            }else {
                map.put(summ, map.get(summ)+1);
            }
        }
        if (map.containsKey(goal)) count+=map.get(goal);
        return count;
    }
}