import java.util.*;

class Solution {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int left = 1, right = n;
        int i = 0;
        while (i < n) {
            if (k > 1) {
                answer[i++] = (k % 2 == 0) ? right-- : left++;
                k--;
            } else {
                answer[i++] = left++;
            }
        }
        return answer;
    }
}