// T- O(nlogn) + O(n3)
// S- O(1)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i<n; i++){
            if (i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j<n; j++){
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while (k<l){
                // addition is done like this so as to avoid overflow error
                    long summ = nums[i];
                    summ+=nums[j];
                    summ+=nums[k];
                    summ+=nums[l];
                    if (summ<target){
                        k++;
                    }else if (summ>target){
                        l--;
                    }else{
                        List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ret.add(ls);
                        k++;
                        l--;
                        while (k<l && nums[k] == nums[k-1]) k++;
                        while (k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ret;
    }
}