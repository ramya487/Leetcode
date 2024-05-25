from collections import Counter
class Solution:
    def minAnagramLength(self, s: str) -> int:
        minn = len(s)
        for i in range(1,len(s)//2+1):
            if not(len(s)%i == 0):
                continue
            lst = []
            for j in range(0,len(s),i):
                substr = s[j:j+i]
                lst.append(substr)
            for m in range(len(lst)-1):
                if not(Counter(lst[m]) == Counter(lst[m+1])):
                    break
            else:
                minn = min(len(lst[0]), minn)
        return minn