class Solution {
public:
    int hIndex(vector<int>& c) {
        int n=c.size();
        sort(c.begin(),c.end());
        reverse(c.begin(),c.end());
        for(int i=n-1;i>=0;i--){
            if(c[i]>=i+1)
                return i+1;
        }
        return 0;
    }
};