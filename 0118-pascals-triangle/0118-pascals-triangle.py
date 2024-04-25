class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        initlst = [[1]]
        for i in range(1,numRows):
            l = []
            lst = initlst[i-1]
            for j in range(i+1):
                if j-1>=0 and j<len(lst):
                    l.append(lst[j-1]+lst[j])
                else:
                    l.append(1)
            initlst.append(l)
            print("pass ",i)
            print(initlst)
        return initlst
