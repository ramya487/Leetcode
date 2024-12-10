class Solution {
public:
    int largestHisto(vector<int> arr){
        stack<int>st;
        int maxi =0;
        int n =arr.size();
        for(int i=0;i<=n;i++){
            while(!st.empty()&&(i==n ||arr[st.top()]>=arr[i])){
                int h = arr[st.top()];
                st.pop();
                int w;
                if(st.empty()) w=i;
                else w=i-st.top()-1;

                maxi=max(maxi,(h*w));
            }
            st.push(i);
        }
        return maxi;
    }
    int maximalRectangle(vector<vector<char>>& matrix) {
        int maxi =0 ;
        int n=matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> pref(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (matrix[i][j] == '1') {
                    pref[i][j] = (i == 0) ? 1 : pref[i-1][j] + 1;
                } else {
                    pref[i][j] = 0;
                }
            }
        }
        for(int i=0;i<n;i++){
            maxi = max(maxi,largestHisto(pref[i]));
        }
        return maxi;
    }
};