public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, n);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        
        int pivot = nums[left + (int)(Math.random()* (right - left))];
        int i = left, j = right;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            }
        }
        if (left + k - 1 <= j) {
            return quickSelect(nums,left, j, k);
        } 
        if (left + k - 1 >= i) {
            return quickSelect(nums, i, right, k - i + left);
        }
        return pivot;
    }
}