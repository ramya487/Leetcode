class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left = len(nums)-2
        right = len(nums)-1
        last = len(nums)-1
        if left == right:
            return
        flag = 0
        while left>=0 and flag == 0:
            if nums[left]>=nums[right]:
                left-=1
                right-=1
            else:
                while (nums[last] <= nums[left]):
                    last-=1
                nums[last],nums[left] = nums[left],nums[last]
                last = len(nums)-1
                nums[left+1:] = sorted(nums[left+1:])
                flag = 1
        if flag == 0:
            nums.sort()