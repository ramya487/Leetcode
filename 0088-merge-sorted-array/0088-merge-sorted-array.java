// using extra space
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m+n];
        int ptr1 = 0;
        int ptr2 = 0;
        int counter = 0;
        while (ptr1<m && ptr2<n){
            if (nums1[ptr1] < nums2[ptr2]){
                newArr[counter] = nums1[ptr1];
                counter++;
                ptr1++;
            }else{
                newArr[counter] = nums2[ptr2];
                counter++;
                ptr2++;
            }
        }
        while (ptr1 != m){
            newArr[counter] = nums1[ptr1];
            counter++;
            ptr1++;
        }
        while (ptr2 != n){
            newArr[counter] = nums2[ptr2];
            counter++;
            ptr2++;
        }
        for (int i = 0; i<nums1.length; i++){
            nums1[i] = newArr[i];
        }
    }
}