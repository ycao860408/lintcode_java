public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] A, int m) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i < m + 1; i++ ) {
            dp[i] = 0;
            for (int j = 0; j < n; j++ ) {
                if (i >= A[j]){
                    dp[i] += dp[i - A[j]];
                }
            }
        }
        return dp[m];
    }
}