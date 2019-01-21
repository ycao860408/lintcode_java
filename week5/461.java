public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int [] nums, int left, int right, int k) {
        
        int pivot = nums[left + (int)(Math.random()*(right - left))];
        int i = left, j = right;
        
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            
            if (i <= j) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            }
        }
        
        if (k + left - 1 <= j) {
            return quickSelect(nums, left, j, k);
        }
        if (k + left - 1 >= i) {
            return quickSelect(nums, i, right, k - (i - left));
        }
        return pivot;
    }
}