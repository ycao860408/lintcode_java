public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k || k<=0) {
            return new int[0];
        }
        
        int[] sum = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sum[0]+= nums[i];
        }
        
        for (int i = k; i < nums.length; i++) {
            sum[i - k + 1] = sum[i - k] - nums[i - k] + nums[i];
        }
        return sum;
    }
}

// 同向双指针的思路表达： 

public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k || k<=0) {
            return new int[0];
        }
        
        int[] sum = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sum[0]+= nums[i];
        }
        
        for (int i = k, j = 1; i < nums.length; i++, j++) {
            sum[j] = sum[j - 1] - nums[i - k] + nums[i];
        }
        return sum;
    }
}