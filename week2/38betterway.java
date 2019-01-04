public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length - 1;
        int col = 0;
        int count =0;
        
        while (col < matrix[0].length && row >=0) {
            if (target == matrix[row][col]) {
                count ++;
                row --;
                col++;
                continue;
            }
            
            if (matrix[row][col] > target) {
                row --;
            } else {
                col ++;
            }
        }
        return count;
    }
}