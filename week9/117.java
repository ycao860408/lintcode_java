public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int n = A.length; 
        int [] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 < dp[i] && A[j] >= i - j) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[n - 1] == Integer.MAX_VALUE ? 0 : dp[n - 1];
    }
}