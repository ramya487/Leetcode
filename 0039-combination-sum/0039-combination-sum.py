class Solution:
    def recur(self, ind, req, l, arr, D):
        if ind == len(arr):
            if req == 0:
                D.append(list(l))
            return
        if arr[ind]<=req:
            l.append(arr[ind])
            self.recur(ind, req-arr[ind], l, arr, D)
            l.pop()
        self.recur(ind+1, req, l, arr, D)
    def combinationSum(self, arr: List[int], target: int) -> List[List[int]]:
        D = []
        self.recur(0, target, [], arr, D)
        return D
