int init = [](){
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    return -1;
}();

class Solution {
public: 
    vector<int> getMaxSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> ans;
        for (int i = 0; i < n; ++i) {
            while (!ans.empty() && ans.back() < nums[i] && ans.size() + n - i - 1 >= k) 
                ans.pop_back();
            if (ans.size() < k) 
                ans.push_back(nums[i]);
        }
        return ans;
    }
    
    bool isGreater(vector<int> &word1, vector<int> &word2, int i, int j) {
        while (i < word1.size() && j < word2.size()) {
            if (word1[i] > word2[j]) 
                return true;
            else if (word1[i] < word2[j]) 
                return false;
            i++, j++;
        }
        return i != word1.size();
    }

    vector<int> merge(vector<int> &a, vector<int> &b) {
        vector<int> ans;
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a[i] > b[j]) 
                ans.push_back(a[i++]);
            else if (a[i] < b[j]) 
                ans.push_back(b[j++]);
            else {
                if (isGreater(a, b, i, j)) 
                    ans.push_back(a[i++]);
                else 
                    ans.push_back(b[j++]); 
            }
        }
        while (i < a.size()) 
            ans.push_back(a[i++]);
        while (j < b.size()) 
            ans.push_back(b[j++]);
        return ans;
    }

    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<int> ans(k, 0);
        int n1 = nums1.size(), n2 = nums2.size();
        for (int i = max(0, k - n2); i <= min(k, n1); ++i) {
            if (i > n1 || k - i > n2) 
                continue;
            vector<int> a = getMaxSubsequence(nums1, i);
            vector<int> b = getMaxSubsequence(nums2, k - i);
            vector<int> tmp = merge(a, b);
            if (isGreater(tmp, ans, 0, 0)) 
                ans = tmp;
        }
        return ans;
    }
};