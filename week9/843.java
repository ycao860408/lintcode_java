public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for (int i = 1; i <= n; i++) {
            if (nums[i-1] == 0) {
                dp[i][0] = Math.min(dp[i-1][0],dp[i - 1][1]);
                dp[i][1] = 1 + dp[i - 1][1];
            } else {
                dp[i][0] = 1 + Math.min(dp[i-1][0],dp[i - 1][1]);
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}