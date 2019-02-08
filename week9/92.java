public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        boolean [][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;
        
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = false;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
               if (j - A[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i-1][j - A[i - 1]];
               } else {
                   dp[i][j] = dp[i - 1][j];
               }
            }
        }
        
        int res = 0; 
        for (int i = m; i >=0;i--) {
            if (dp[n][i]) {
                res = i;
                break;
            }
        }
        
        return res;
        
    }
}