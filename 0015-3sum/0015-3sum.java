// T- O(n2*log(unique triplets))
// S- O(n) + O(unique triplets)
// hashset

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i<n; i++){
            Set<Integer> temp = new HashSet<>();
            for (int j = i+1; j<n; j++){
                int t = 0-(nums[i]+nums[j]);
                if (temp.contains(t)){
                    List<Integer> ls = Arrays.asList(nums[i], nums[j], t);
                    ls.sort(null);
                    st.add(ls);
                }
                temp.add(nums[j]);
            }
        }
        List<List<Integer>> ret = new ArrayList<>(st);
        return ret;
    }
}