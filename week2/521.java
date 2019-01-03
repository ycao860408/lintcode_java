public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int res = 1, inloc = 0, newVal = nums[0];
        
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == newVal) {
                continue;
            }
            inloc++;
            nums[inloc] = nums[i];
            newVal = nums[i];
            res++;
        }
        return res;
        
    }
}