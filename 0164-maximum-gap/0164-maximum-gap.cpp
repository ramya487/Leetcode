class Solution {
public:
    int maximumGap(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int ma = 0;
        if(nums.size()<2){
        return ma;
        }
        for(int i=1;i<nums.size();i++){
        ma = max(ma,nums[i]-nums[i-1]);
        }
        return ma;
    }
};