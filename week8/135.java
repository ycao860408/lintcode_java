public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1 ]) {
                continue;
            } 
            nums.add(candidates[i]);
        }
        dfs(nums, 0,target, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(List<Integer> nums, int index, int target, List<Integer> cur, List<List<Integer>> res) {
        if (index == nums.size()) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for(int cnt = 0;  cnt * nums.get(index) <= target; cnt++ ) {
            for (int i =0; i < cnt; i++) {
                cur.add(nums.get(index));
            }
            dfs(nums, index + 1, target - cnt * nums.get(index), cur, res);
            for (int i = 0; i < cnt; i++) {
                cur.remove(cur.size() - 1);
            }
        }
    }
}