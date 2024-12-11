class Solution {
public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int len = nums.size();

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if(nums.subList(i, j).size() >= l && nums.subList(i, j).size() <= r) {
                    int sum = nums.subList(i, j).stream().reduce(Integer::sum).orElse(0);
                    if(sum > 0) {
                        minSum = Math.min(sum, minSum);
                    }
                }
            }
        }

        if(minSum ==Integer.MAX_VALUE) return -1;
        return minSum > 0 ? minSum : -1;
    }
}