public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length; 
        int [] sum = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i - 1] + values[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }
        
        for (int len = 2; len <= n; len ++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = sum[j + 1] - sum[i] - Math.min(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > sum[n] / 2;
    }
}