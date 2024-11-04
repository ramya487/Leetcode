// T- O(N)
// S- O(N)
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int first = 0;
        int next = 1;
        int req = first+next;
        for (int i = 2; i<=n; i++){
            req = first+next;
            first = next;
            next = req;
        }
        return req;
    }
}