public class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int dp[][] = new int[n + 1][target + 1];
        
        dp[0][0] = 1;
        
        for (int i = 1; i < target + 1; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}