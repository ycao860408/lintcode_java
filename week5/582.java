public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        int ans = 0;
        if (nums == null || nums.length < 2) {
            return ans;
        }
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; r--) {
            while (l < r && nums[l] + nums[r] < target) {
                l++;
            }
            if (l!= r && nums[l] + nums[r] == target) {
                ans++;
                while (l < r && nums[r] == nums[r - 1]) {
                    r--;
                }
            }
        }
        return ans;
    }
}


