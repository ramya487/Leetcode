class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 1){
            List<Integer> barr = new ArrayList<>();
            barr.add(0);
            barr.add(1);
            return barr;
        }
        
        List<Integer> subarr = grayCode(n-1);
        List<Integer> ans = new ArrayList<>();
        
        for(int curr : subarr){ 
            ans.add(curr);
        }
        
        for(int i = subarr.size()-1 ; i >=0 ; i--){
            int curr = subarr.get(i);
            int mask = 1<<(n-1);
            curr = curr | mask;
            ans.add(curr);
        }
        
        return ans;
    }
}