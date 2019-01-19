public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int ans = 0;
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; r--) {
            while (l < r && nums[r] + nums[l] <= target) {
                l++;
            }
            if (l < r) {
                ans += (r - l);
            }
        }
        return ans;
    }
}