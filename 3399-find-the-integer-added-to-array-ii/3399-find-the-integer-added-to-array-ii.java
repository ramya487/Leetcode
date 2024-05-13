class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int minn = Integer.MAX_VALUE;
        for (int i = 0; i<nums1.length; i++){
            for (int j = i+1; j<nums1.length; j++){
                List<Integer> lst = new ArrayList<Integer>();
                for (int k = 0; k<nums1.length; k++){
                    if (k != i && k != j){
                        lst.add(nums1[k]);
                    }
                }
                int ind = nums2[nums2.length-1] - lst.get(lst.size() - 1);
                int flag = 0;
                for (int counter = 0; counter<nums2.length; counter++){
                    if (nums2[counter] - lst.get(counter) != ind){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0){
                    minn = Math.min(minn, ind);
                }
            }
        }
        return minn;
    }
}