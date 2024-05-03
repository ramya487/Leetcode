// O(N+M)
// O(M)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = null;
        int flag = 0;
        for (int i = 0; i<matrix.length; i++){
            if (matrix[i][0] == target){
                return true;
            }else if (matrix[i][0] > target && i != 0){
                arr = matrix[i-1];
                flag = 1;
                break;
            }else if (matrix[i][0] > target && i == 0){
                return false;
            }
        }
        if (flag == 0){
            arr = matrix[matrix.length -1];
        }

        for (int i = 0; i<arr.length; i++){
            if (arr[i] == target){
                return true;
            }
        }
        return false;
    }
}