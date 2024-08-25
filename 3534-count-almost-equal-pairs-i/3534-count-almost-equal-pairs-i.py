class Solution:
    def countPairs(self, nums: List[int]) -> int:
        counter = 0
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                val1 = list(map(int, str(nums[i])))
                val2 = list(map(int, str(nums[j])))
                if len(val1)<len(val2):
                    val1 = [0 for _ in range(len(val2) - len(val1))]+val1
                elif len(val2)<len(val1):
                    val2 = [0 for _ in range(len(val1) - len(val2))]+val2
                c1 = []
                c2 = []
                for _ in range(len(val1)):
                    if val1[_] != val2[_]:
                        c1.append(val1[_])
                        c2.append(val2[_])
                    if len(c1)>2:
                        break
                else:
                    if len(c1) == 0:
                        counter+=1
                    if len(c1) == 2:
                        if sorted(c1) == sorted(c2):
                            counter+=1
        return counter
