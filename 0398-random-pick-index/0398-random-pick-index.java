class Solution {
    Map<Integer, List<Integer>> m;
    Random rand;

    public Solution(int[] nums) {
        m = new HashMap();
        for(int i=0; i<nums.length; ++i){
            m.computeIfAbsent(nums[i], (k) -> new ArrayList()).add(i);
        }

        rand = new Random();
    }
    
    public int pick(int target) {
        if(m.get(target).size() == 1) return m.get(target).get(0);
        // int randIdx = m.get(target).size();
        return m.get(target).get(rand.nextInt(m.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */