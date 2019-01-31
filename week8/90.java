public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(A, 0, k, target, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int index, int k, int target, List<Integer> cur, List<List<Integer>> res) {
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        
        if (target < 0 || index == nums.length) {
            return;
        }
        
        cur.add(nums[index]);
        dfs(nums, index + 1, k - 1, target - nums[index], cur, res);
        cur.remove(cur.size() - 1);
        dfs(nums, index + 1, k, target, cur, res);
    }
}

// 跳跃搜索 

public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(A, 0, k, target, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int index, int k, int target, List<Integer> cur, List<List<Integer>> res) {
        if (k == 0) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        
        if (target < 0) {
            return;
        }
        
       for (int i = index;i < nums.length; i++) {
           cur.add(nums[i]);
           dfs(nums, i + 1, k - 1, target - nums[i], cur, res);
           cur.remove(cur.size() - 1);
       }
    }
}