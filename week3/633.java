public class Solution {
    /**
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // write your code here
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (count(nums, mid) <= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (count(nums,left) > left) {
            return left;
        }
        return right;
    }
    
    private int count(int[] nums, int val) {
        int sum = 0; 
        for (int item: nums) {
            if (item <= val) {
                sum++;
            }
        }
        return sum;
    }
}