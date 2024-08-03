class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        c1 = 0
        m = len(grid)
        n = len(grid[0])
        for item in grid:
            l = 0
            r = n-1
            while (l<=r):
                if item[l] != item[r]:
                    c1+=1
                l+=1
                r-=1
        mat = [[0 for i in range(m)] for j in range(n)]
        for i in range(m):
            for j in range(n):
                mat[j][i] = grid[i][j]
        
        c2 = 0
        for item in mat:
            l = 0
            r = m-1
            while (l<=r):
                if item[l] != item[r]:
                    c2+=1
                l+=1
                r-=1
        return min(c1,c2)
            
