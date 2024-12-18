class Solution {
public:
    int numTrees(int n) {

        long double ans = 1;

        for (int k = 2; k <= n; k++) {
            ans *= (n + k);
            ans /= k;
        }

        return ans;
    }
};