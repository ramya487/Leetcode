class Solution {
    
    private int getSumDigits(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
    
    public int minElement(int[] nums) {
        int res=Integer.MAX_VALUE;
        for(int num:nums){
            res = Math.min(res, getSumDigits(num));
        }
        return res;
    }
}