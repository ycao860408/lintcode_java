public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                break;
            }
        }
    }
    
    private void reverse(List<Integer> nums, int st, int ed) {
        int l = st, r = ed;
        while (l < r) {
            int temp = nums.get(l);
            nums.set(l, nums.get(r));
            nums.set(r, temp);
            l++;
            r--;
        }
    }
}