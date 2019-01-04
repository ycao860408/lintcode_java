public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0] == null) {
            return 0;
        }
        int i, row = matrix.length, col = matrix[0].length, test, count = 0;
        
        for (i = 0; i < col; i++) {
            if (matrix[0][i] < target) {
                continue;
            } else {
                break;
            }
        }
        
        if (i < col && matrix[0][i] == target) {
            count++;
        }
        
        test = i - 1;
        
        int j; 
        
        for (j = 1; j < row; j++) {
            
            if (matrix[j][0] > target) {
                break;
            } else if (matrix[j][test] < target) {
                continue;
            } else {
                int k;
                for (k = 0; k <= test; k++) {
                    if (matrix[j][k] < target){
                        continue;
                    } else {
                        break;
                    }
                }
                if (matrix[j][k] == target) {
                    count++;
                }
                test = k - 1;
            }
        }
        return count;
    }
}