// T- O(nlogn) + O(n*n)
// S- O(1)
// three pointers
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i<n; i++){
            if (i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while (j<k){
                int summ = nums[i]+ nums[j]+nums[k];
                if (summ<0){
                    j++;
                }else if (summ>0){
                    k--;
                }else{
                    List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k]);
                    ret.add(ls);
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) j++;
                    while (j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ret;
    }
}