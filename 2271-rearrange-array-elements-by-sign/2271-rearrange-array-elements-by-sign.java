// T- O(2n)
// S- O(2n)

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int[] ret = new int[n];
        for (int i = 0; i<n; i++){
            int ele = nums[i];
            if (ele>0) pos.add(ele);
            else neg.add(ele);
        }
        int p = 0;
        int ng = 0;
        for (int i = 0; i<n; i++){
            if (i%2 == 0){
                ret[i] = pos.get(p);
                p++;
            }else{
                ret[i] = neg.get(ng);
                ng++;
            }
        }
        return ret;
    }
}