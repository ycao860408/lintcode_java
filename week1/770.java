public class Solution {
    /**
     * @param matrix: an input matrix 
     * @return: nums[0]: the maximum,nums[1]: the minimum
     */
    public int[] maxAndMin(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return new int[0];
        int[] res = new int [2];
        res[0] = Integer.MIN_VALUE;
        res[1] = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[0] = Math.max(res[0], matrix[i][j]);
                res[1] = Math.min(res[1], matrix[i][j]);
            }
        }
        return res;
    }
}