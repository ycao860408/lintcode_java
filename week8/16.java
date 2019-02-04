public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>>res = new ArrayList<>();
        boolean[] done = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            done[i] = false;
        }
        Arrays.sort(nums);
        dfs(nums, 0, done, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int level, boolean[] done, List<Integer> cur, List<List<Integer>> res) {
        if (level == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!done[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && !done[i - 1]) {
                    continue;
                }
                done[i] = true;
                cur.add(nums[i]);
                dfs(nums, level + 1, done, cur, res);
                done[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
};