class Solution {
public:
    bool increasingTripletLargeSpace(vector<int>& nums) {
        int n = nums.size();
        vector<int> smaller(n, -1);
        smaller[0] = nums[0];
        vector<int> larger(n, -1);
        larger[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            smaller[i] = min(smaller[i-1], nums[i-1]);
        }
        for(int i = n-2; i >= 0; i--) {
            larger[i] = max(larger[i+1], nums[i+1]);
        }
        for(int i = 0; i < n; i++) {
            if(smaller[i] < nums[i] && nums[i] < larger[i]) return 1;
        }
        return 0;
    }
    bool increasingTriplet(vector<int>& nums) {
        int n = nums.size();
        int small = INT_MAX, curr = INT_MAX;
        for(int large: nums) {
            if(large > curr) return 1;
            if(large < small)
                small = large;
            else if(large > small && large < curr)
                curr = large;
        }
        return 0;
    }
};