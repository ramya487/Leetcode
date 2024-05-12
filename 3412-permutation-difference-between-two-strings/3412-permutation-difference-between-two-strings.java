class Solution {
    public int findPermutationDifference(String s, String t) {
        int ans = 0;
        for (int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            int index = t.indexOf(c);
            int summ = Math.abs(i-index);
            ans+=summ;
        }
        return ans;
    }
}