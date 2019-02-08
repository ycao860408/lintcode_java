public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A.length == 0) {
            return 0;
        }
        
        int icr = 1, dcr = 1, longest = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                icr++;
                dcr = 1;
            } else if (A[i] < A[i - 1]) {
                dcr++;
                icr = 1;
            } else {
                icr = 1 ;
                dcr = 1 ;
            }
            longest = Math.max(longest, Math.max(icr, dcr));
        }
        return longest;
    }
}

// sliding array to optimize the space complexity

public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[2][n];
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = Math.min(dp[(i - 1) %2][j], dp[i % 2][j-1]) + grid[i][j];
            }
        }
        return dp[(m-1) % 2][n - 1];
    }
}