public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int [] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < sum.length; i++) {
            min = Math.min(min,sum[i - 1]);
            ans = Math.max(ans,sum[i] - min);
        }
        return ans;
    }
}