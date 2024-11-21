// T- O(2N)
// S- O(1)
// counter
class Solution {
    public void sortColors(int[] nums) {
        int[] hashArry = new int[3];
        for (int i = 0; i<nums.length; i++){
            hashArry[nums[i]]++;
        }
        int counter = 0;
        for (int i = 0; i<nums.length; i++){
            while (hashArry[counter] == 0) counter++;
            nums[i] = counter;
            hashArry[counter]--;
        }
    }
}