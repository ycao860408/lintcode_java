public class Solution {
    /**
     * @param strs: an array with strings include only 0 and 1
     * @param m: An integer
     * @param n: An integer
     * @return: find the maximum number of strings
     */
    int ans = 0;
    public int findMaxForm(String[] strs, int m, int n) {
        // write your code here
        
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int cnt0[] = new int[strs.length];
        int cnt1[] = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    cnt0[i]++;
                }else {
                    cnt1[i]++;
                }
            }
        }
        dfs(cnt0, cnt1,0, m, n, 0);
        return ans;
    }
    
    private void dfs(int[] cnt0, int[]cnt1,int level, int m, int n, int num) {
        if (level == cnt0.length) {
            ans = Math.max(ans, num);
            return;
        }
        
        if (cnt0.length - level + num < ans){
            return;
        }   // pruning 
        
        if (cnt0[level] <= m && cnt1[level] <= n) {
            dfs(cnt0, cnt1, level + 1, m - cnt0[level], n - cnt1[level], num + 1);
        }
         dfs(cnt0, cnt1, level + 1, m, n, num);
    }
}

// we do not have to test m == 0 or n == 0, because we do not have to use up all the zeros and ones. 
// 0-1 背包