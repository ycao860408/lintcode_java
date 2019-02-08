public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for(int i = 1; i < m + 1; i++) {
            dp[0][i] = -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if ( j >= A[i - 1] && dp[i- 1][j - A[i - 1]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - A[i - 1]] + V[i - 1]);
                } 
            }
        }
        int ans = 0; 
        
        for (int j = 0; j <= m; j++) {
            if (dp[n][j] != -1) {
                 ans = Math.max(ans, dp[n][j]);
            }
        }
        return ans;
    }
}