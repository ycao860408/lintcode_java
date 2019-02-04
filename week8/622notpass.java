public class Solution {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    boolean ans = false;
    public boolean canCross(int[] stones) {
        // write your code here
        if (stones == null || stones.length == 0) {
            return false;
        }
        dfs(stones, 0, 1, 1);
        return ans;
    }
    
    private void dfs(int[] stones, int cur, int st, int ed) {
        
        if (cur == stones.length - 1) {
            ans = true;
            return;  
        }
        if (ans) {
            return;
        }
        for (int i = cur + 1; i < stones.length;i++) {
            int delta = stones[i] - stones[cur];
            if (delta > ed) {
                break;
            }
            if (delta < st) {
                continue;
            }
            dfs(stones, i, delta - 1, delta + 1);
        }
    }
}