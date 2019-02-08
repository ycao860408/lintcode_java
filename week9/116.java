public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        int n = A.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            dp[i] = false;
            for (int j =0 ; j < i; j++) {
                if (dp[j] == true && A[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}