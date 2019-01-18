public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int [] ans = new int[2];
        if (nums == null || nums.length < 2) {
            return ans;
        }
        for (int l = 0, r = nums.length - 1; l < r; r--) {
            while (l < r && nums[l] + nums[r] < target) {
                l++;
            }
            if (l < r && nums[l] + nums[r] == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                Arrays.sort(ans);
                return ans;
            }
        }
        return ans;
    }
}