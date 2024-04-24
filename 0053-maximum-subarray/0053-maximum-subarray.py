import sys
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxval = -sys.maxsize-1
        summ = 0
        for i in range(len(nums)):
            summ+=nums[i]
            maxval = max(maxval, summ)
            if summ<0:
                summ = 0
        return maxval