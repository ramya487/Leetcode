// moore voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 0;
        for (int item: nums){
            if (count == 0){
                ele = item;
                count = 1;
            }
            else if (ele == item){
                count++;
            }else {
                count--;
            }
        }
        return ele;
    }
}