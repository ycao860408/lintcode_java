public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i >0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            twoSum(numbers, i + 1, -numbers[i], res);
        }
        return res;
    }
    
    private void twoSum(int[] nums, int st, int target, List<List<Integer>> res) {
        for (int l = st, r = nums.length - 1; l < r; r--) {
            while (l < r && nums[l] + nums[r] < target) {
                l++;
            }
            if (l < r && nums[r] + nums[l] == target) {
                List<Integer> item = new ArrayList<>();
                item.add(-target);
                item.add(nums[l]);
                item.add(nums[r]);
                res.add(item);
                while (l < r && nums[r] == nums[r - 1]) {
                    r--;
                }
            }
        }
    }
}