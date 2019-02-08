public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] a) {
        // write your code here
        if (a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        int ans = 0;
        for (int i = 1; i < a.length; i++) {
            dp[i] = dp[i - 1] + Math.max(0, a[i] - a[i - 1]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}