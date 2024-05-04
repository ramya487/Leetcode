# O(N) - T
# O(N) - S
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        lst1 = list(map(int, version1.split(".")))
        lst2 = list(map(int, version2.split(".")))
        while len(lst1)<len(lst2):
            lst1.append(0)
        while len(lst2)<len(lst1):
            lst2.append(0)
        if lst1<lst2: return -1
        elif lst1>lst2: return 1
        return 0