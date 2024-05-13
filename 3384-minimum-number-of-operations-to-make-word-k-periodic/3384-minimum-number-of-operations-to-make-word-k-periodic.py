class Solution:
    def minimumOperationsToMakeKPeriodic(self, word: str, k: int) -> int:
        d = {}
        for i in range(0,len(word), k):
            substr = word[i:i+k]
            if substr not in d:
                d[substr] = 1
            else:
                d[substr]+=1
        maxx = max(list(d.values()))
        return sum(list(d.values())) - maxx