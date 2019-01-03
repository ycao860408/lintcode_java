public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            }
            
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
        }
        
        if (nums[left] > nums[right]) {
            return nums[left];
        }
        return nums[right];
    }
}