public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        int left = 0, right = nums.length;
        
        while ( left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[left] == target)
            return left;
        if (nums[right] == target) 
            return right;
        return -1;
    }
}