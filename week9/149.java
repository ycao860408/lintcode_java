public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] a) {
        // write your code here
        // dp[i] max profit when we sell the stock on ith day +> dp[k], 1 <= k <= n
        // dp[i] = a[i] - a[i - 1] + dp[i - 1] || a[i] - a[i - 1]
        if (a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        int ans = 0;
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i]- a[i - 1], a[i] - a[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}