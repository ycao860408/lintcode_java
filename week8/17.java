public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    private void dfs(int[] nums, int level, List<Integer>cur) {
        if (level == nums.length) {
            List<Integer> dc = new ArrayList<>(cur);
            res.add(dc);
            return;
        }
        cur.add(nums[level]);
        dfs(nums, level + 1, cur);
        cur.remove(cur.size() - 1);
        dfs(nums, level + 1, cur);
    }
}

// 没有全局变量的写法： 
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int level, List<Integer>cur, List<List<Integer>> res) {
        if (level == nums.length) {
            List<Integer> dc = new ArrayList<>(cur);
            res.add(dc);
            return;
        }
        cur.add(nums[level]);
        dfs(nums, level + 1, cur, res);
        cur.remove(cur.size() - 1);
        dfs(nums, level + 1, cur, res);
    }
}

// 跳跃搜索 

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, int level, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        for (int i = level; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}