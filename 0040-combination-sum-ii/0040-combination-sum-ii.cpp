class Solution {
public:
    void kavya(vector<vector<int>>&ans,vector<int>&a,vector<int>& candidates,int target,int ind){
        if(target==0){
            ans.push_back(a);
            return;
        }
    for(int i=ind;i<candidates.size() && target>=candidates[i];i++){
            if(i==ind || candidates[i]!=candidates[i-1]){
                a.push_back(candidates[i]);
                kavya(ans,a,candidates,target-candidates[i],i+1);
                a.pop_back();
            }
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
         vector<vector<int>> ans;
         vector<int>a;
         kavya(ans,a,candidates,target,0);
         return ans;
    }
};