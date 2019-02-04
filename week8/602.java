public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    int ans = 0;
    
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, Comparator.comparing(a -> a[0]));
        
        dfs(envelopes, 0, 0);
        return ans;
    }
    
    private void dfs(int[][] envelopes, int cur, int num) {
        ans = Math.max(ans, num);
        for (int i = cur; i < envelopes.length; i++) {
            if (cur ==0 || envelopes[i][0] > envelopes[cur - 1][0] && envelopes[i][1] > envelopes[cur - 1][1]){
                dfs(envelopes, i + 1, num + 1);
            }
        }
    }
}