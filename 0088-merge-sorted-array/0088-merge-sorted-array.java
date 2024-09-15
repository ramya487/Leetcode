// T- O(n)
// S- O(n)
// two ptrs
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m-1;
        int r = n-1;
        int p = m+n-1;
        while (r>=0) {
            if (l>=0 && nums1[l] > nums2[r]){
                nums1[p] = nums1[l];
                l--;
            }else{
                nums1[p] = nums2[r];
                r--;
            }
            p--;
        }
    }
}