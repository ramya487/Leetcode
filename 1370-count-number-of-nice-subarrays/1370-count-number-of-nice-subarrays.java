class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i<nums.length; i++){
            if (nums[i]%2 == 0) nums[i] = 0;
            else nums[i] = 1;
        }

        int summ = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //sum: frequency
        for (int i = 0; i<nums.length; i++){
            summ+=nums[i];
            int diff = summ - k;
            if (map.containsKey(diff)) count+=map.get(diff);
            if (!map.containsKey(summ)) map.put(summ, 1);
            else map.put(summ, map.get(summ)+1);
        }
        if (map.containsKey(k)) count+=map.get(k);
        return count;
    }
}