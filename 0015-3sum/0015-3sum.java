class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Set<Integer> ele = new HashSet<Integer>();
        for (int i = 0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                int temp = -(nums[i]+nums[j]);
                if (ele.contains(temp)){
                    List<Integer> lst = Arrays.asList(nums[i], nums[j], temp);
                    lst.sort(null);
                    set.add(lst);
                }
                ele.add(nums[j]);
            }
            ele.clear();
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}