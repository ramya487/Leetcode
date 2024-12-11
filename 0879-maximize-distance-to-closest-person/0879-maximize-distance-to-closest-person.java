class Solution {
    public int maxDistToClosest(int[] seats) {
        //we will check for maximum consecutive zeros
        //and middle of that maximum consecutive zeros will be our answer
        //but there will be two edge cases
        //one with prefix zeros and one with suffix zeros
        int prefixZeros = -1;
        int suffixZeros = -1;
        int maxZeros = -1;
        int zeros = 0;
        for(int i = 0;i < seats.length;i++){
            if(seats[i] == 0){
                zeros++;
            }else{
                if(prefixZeros == -1){
                    prefixZeros = zeros;
                }else{
                    maxZeros = Math.max(maxZeros, zeros);
                }
                zeros = 0;
            }
        }
        suffixZeros = zeros;
        int res = Math.max(Math.max(prefixZeros, suffixZeros), (maxZeros + 1) / 2);
        return res;
    }
}