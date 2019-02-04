public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    int n;
    boolean[] done;
    int[] selected;
    int[] A;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        A = nums;
        n = A.length; 
        done =new boolean[n];
        selected = new int[n];
        for (int i = 0; i < n; i++) {
            done[i] = false;
        }
        dfs(0);
        return res;
    }
    
    private void dfs(int level) {
        if (level == n) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(selected[i]);
            }
            res.add(temp);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!done[i]) {
                done[i] = true;
                selected[level] = A[i];
                dfs(level + 1);
                done[i] = false;
            }
        }
    }
}

// no global variables:  
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        boolean done [] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            done[i] = false;
        }
        List<List<Integer>> res = new ArrayList<>();
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
                cur.add(nums[i]);
                done[i] = true;
                dfs(nums, level + 1, done, cur, res);
                cur.remove(cur.size() - 1);
                done[i] = false;
            }
        }
    }
}