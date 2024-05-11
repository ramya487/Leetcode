// T - O(N+N/2)
// S - O(N)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<Integer>();
        List<Integer> neg = new ArrayList<Integer>();
        int[] ans = new int[nums.length];
        for (int i = 0; i<nums.length; i++){
            if (nums[i] >=0){
                pos.add(nums[i]);
            }else {
                neg.add(nums[i]);
            }
        }
        int counter = 0;
        for (int i = 0; i<nums.length/2; i++){
            ans[counter] = pos.get(i);
            ans[counter+1] = neg.get(i);
            counter+=2;
        }
        return ans;
    }
    
}