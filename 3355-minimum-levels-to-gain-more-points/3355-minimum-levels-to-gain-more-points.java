class Solution {
    public int minimumLevels(int[] possible) {
        int tot = 0;
        int n = possible.length;
        for (int i = 0; i<n; i++) tot+=(possible[i] == 0) ? -1 : 1;

        int summ = 0;
        for (int i = 0; i<n-1; i++){
            summ+=(possible[i] == 0) ? -1 : 1;
            if (summ > tot-summ) return i+1;
        }
        return -1;
    }
}