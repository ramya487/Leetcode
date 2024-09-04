from collections import Counter
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        c = Counter(nums)
        lst = [k for k in c if c[k]>=2]
        return lst[0]