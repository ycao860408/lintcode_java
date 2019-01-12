public class Solution {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k) {
            return 0.0;
        }
        double left = nums[0], right = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }
        
        while (left + 1e-5 < right) {
            double mid = (right + left) / 2;
            if (canFind(nums, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (canFind(nums,left,k)) 
            return left;
      
        return right;
     
    }
    
    private boolean canFind(int[] nums, double avg, int k) {
        double leftSum = 0, rightSum = 0, minLeftSum = 0;
        
        for (int i = 0; i < k; i++) {
            rightSum += nums[i] - avg;
        }
        for (int i = k; i <= nums.length; i++) {
            if (rightSum - minLeftSum >= 0) {
                return true;
            }
            if (i < nums.length) {
                leftSum += nums[i - k] - avg;
                rightSum += nums[i] - avg;
                minLeftSum = Math.min(leftSum, minLeftSum);
            }
        }
        return false;
    }
}