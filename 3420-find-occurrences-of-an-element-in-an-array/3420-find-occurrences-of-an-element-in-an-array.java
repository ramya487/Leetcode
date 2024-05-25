class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> lst = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 0; i<n; i++){
            if (nums[i] == x) lst.add(i);
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i<m; i++){
            int indx = queries[i]-1;
            ans[i] = (indx > lst.size()-1) ? -1 : lst.get(indx); 
        }
        return ans;
    }
}