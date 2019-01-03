public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    private int searchRow(int[][] matrix, int target){
        int top = 0, bot = matrix.length - 1;
        
        while (top + 1 < bot) {
            int mid = top + (bot - top) / 2;
            
            if (matrix[mid][0] < target) {
                top = mid;
            } else {
                bot = mid;
            }
        }
        if (matrix[bot][0] <= target) {
            return bot;
        }
        return top;
    }
    // The first half can be viewed as a section search.
    
    private int searchCol(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return mid;
            }
            
            if (matrix[row][mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (matrix[row][left] == target) {
            return left;
        }
        
        if (matrix[row][right] == target) {
            return right;
        }
        
        return -1;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = searchRow(matrix, target);
        int index = searchCol(matrix, target, row);
        
        if (index != -1) 
            return true;
        return false;
    }
}