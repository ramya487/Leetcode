// two ptrs
// T- O(n)
// S- O(1)
class Solution {
    public int maxArea(int[] height) {
        int n = height.length, l = 0, r = n-1;
        int maxx = Integer.MIN_VALUE;
        while (l<r){
            maxx = Math.max(maxx, (r-l)*Math.min(height[l], height[r]));
            if (height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxx;
    }
}