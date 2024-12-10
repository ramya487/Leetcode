class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        
        sb.append(nums[0]);        

        if(n == 1) return sb.toString();
        if(n ==2) return sb.append("/").append(nums[1]).toString();

        sb.append("/(");
        
        for(int i = 1; i < n; i++)
            sb.append(nums[i]).append("/");
        
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");

        return sb.toString();
    }
}