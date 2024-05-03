class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        for i in range(len(matrix)):
            if matrix[i][0] == target:
                return True
            elif matrix[i][0] > target and i != 0:
                temp = matrix[i-1]
                break
            elif matrix[i][0] > target and i == 0:
                return False
        else:
            temp = matrix[-1]
        for element in temp:
            if element == target:
                return True
        return False
        
        