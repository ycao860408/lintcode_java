public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        boolean dp[] = new boolean[n + 1];
        if (n == 0) {
            return false;
        }
        dp[1] = true;
        dp[0] = false;
        for (int i = 2; i <= n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 2]);
        }
        return dp[n];
    }
}