public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        int n = s.length();
        char[] scr = s.toCharArray();
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            dp[i - 1][i] = scr[i] == scr[i - 1];
        }
        
        int left=0, right=0;
        String res = null;
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = false;
                dp[i][j] = dp[i + 1][j - 1] && scr[i] == scr[j];
                if (dp[i][j]) {
                    left = i; 
                    right = j;
                }
            }
        }
        if (left != 0 || right != 0) {
            res = s.substring(left, right + 1);
        } else {
            for(int i = 1; i < n; i++) {
                if (dp[i-1][i]) {
                    res = s.substring(i - 1, i + 1);
                    break;
                }
            }
        }
        return res;
    }
}