# T- O(2N)
# S- O(M) - M no of distinct characters in s
# sliding window + hashing
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        d = {"A":0, "B":0}
        left = 0
        right = 0
        maxx = 0
        while right < len(s):
            if s[right] not in d:
                d[s[right]] = 1
            else:
                d[s[right]]+=1
            while (((right-left + 1) - max(list(d.values()))) > k):
                d[s[left]]-=1
                left+=1
            if (right-left + 1 > maxx):
                maxx = right-left + 1
            right+=1
        return maxx