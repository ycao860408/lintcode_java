public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}