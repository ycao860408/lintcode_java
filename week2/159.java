public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int last = nums[nums.length - 1];
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > last) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            return nums[right];
        }
        
    }
}