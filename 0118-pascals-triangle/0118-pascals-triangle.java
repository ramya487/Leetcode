// T- O(n2)
class Solution {
    public static List<Integer> generateRow(int n){
        int ans = 1;
        List<Integer> ls = new ArrayList<>();
        ls.add(ans);
        for (int i = 1; i<n; i++){
            ans = ans*(n-i);
            ans = ans/i;
            ls.add(ans);
        }
        return ls;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i<=numRows; i++){
            ret.add(generateRow(i));
        }
        return ret;
    }
}