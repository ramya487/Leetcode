class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        Stack<Integer> s = new Stack<Integer>();
        List<Long> lst = new ArrayList<Long>();
        int top;
        long len;
        for (int i = 0; i<nums.length; i++){
            if (!s.empty()){
            top = s.peek();
            if (top == nums[i]){
                len = s.size();
                lst.add(len);
                while (!s.empty()) s.pop();
                s.push(nums[i]);
            }else s.push(nums[i]);
            }else s.push(nums[i]);
        }
        len = s.size();
        lst.add(len);
        long summ = 0;
        long temp;
        long subArrays;
        System.out.println(lst);
        System.out.println(nums.length);
        for (int i = 0; i<lst.size(); i++){
            temp = lst.get(i);
            subArrays = (temp*(temp+1))/2;
            summ+=subArrays;
        }
        return summ;
    }
}