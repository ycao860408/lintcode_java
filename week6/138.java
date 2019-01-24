public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int [] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (!map.containsKey(preSum[i])) {
                map.put(preSum[i],i);
            } else {
                res.add(map.get(preSum[i]));
                res.add(i - 1);
                break;
            }
        }
        return res;
    }
}