public class Solution {
    /**
     * @param strs: an array with strings include only 0 and 1
     * @param m: An integer
     * @param n: An integer
     * @return: find the maximum number of strings
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // write your code here
        if(strs == null || strs.length == 0) {
            return 0;
        }
       
         int s = strs.length;
        int cnt0[] = new int[s];
        int cnt1[] = new int[s];
        for (int i = 0; i < s; i++) {
             char[] cstr = strs[i].toCharArray();
             for (int j = 0; j < cstr.length; j++) {
                 if (cstr[j] == '0') {
                     cnt0[i]++;
                 } else {
                     cnt1[i]++;
                 }
             }
         }
       
        
        int [][][] states = new int[s + 1][m + 1][n + 1];
        for (int i = 1; i <= s; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    states[i][j][k] =states[i - 1][j][k];
                    if (j >=cnt0[i-1] && k >= cnt1[i - 1]) {
                        states[i][j][k] = Math.max(states[i][j][k], states[i - 1][j - cnt0[i-1]][k - cnt1[i-1]]+1);
                    }
                }
            }
        }
        return states[s][m][n];
    }
}