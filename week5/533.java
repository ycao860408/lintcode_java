public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int l = 0, r = nums.length - 1; l < r; r--) {
            while(l < r && nums[l] + nums[r] < target) {
                int diff = Math.abs(nums[r] + nums[l] - target);
                ans = Math.min(diff, ans);
                l++;
            }
            if (l < r) {
                int diff = Math.abs(nums[r] + nums[l] - target);
                ans = Math.min(diff, ans);
            }
        }
        return ans;
    }
}