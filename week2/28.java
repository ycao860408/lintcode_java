public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if ( matrix[mid / col ][mid % col] == target) {
                return true;
            }
            
            if ( matrix[mid / col][mid % col] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (matrix[ left / col][left % col] == target) {
            return true;
        }
        
        if (matrix [ right / col ][right % col] == target) {
            return true;
        }
        return false;
    }
}