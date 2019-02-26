public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        char[] ss = s.toCharArray();
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }
        
        int[][] f = new int[n][n];
        int i, j , len;
        for ( i = 0; i < n ; i++) {
            f[i][i] = 1;
        }
        for ( j = 0; j < n - 1; j++) {
            f[j][j + 1] = ss[j] == ss[j + 1] ? 2 : 1;
        }
        for (len = 3; len <= n; len++) {
            for (i = 0; i <= n - len  ; i++) {
                // j = i + len - 1 , i + len - 1 <= n - 1
                j = i + len - 1;
                f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                if (ss[i] == ss[j]) {
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        return f[0][n-1];
    }
}

// 记忆画搜索
public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    char[] s; 
    int n; 
    int f[][];
    
    
    private void calc(int i, int j) {
        if (f[i][j] != -1) {
            return;
        }
        if (i == j) {
            f[i][j] = 1;
            return;
        }
        if (i == j - 1) {
            f[i][j] = s[i] == s[j] ? 2 : 1;
            return;
        }
        calc(i + 1, j); 
        calc(i, j - 1);
        calc(i+ 1, j - 1);
        
        f[i][j] = Math.max(f[i+1][j], f[i][j - 1]);
        if (s[i] == s[j]) {
            f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
        }
    }
    public int longestPalindromeSubseq(String ss) {
        // write your code here
        s = ss.toCharArray();
        n = ss.length();
        if (n == 0 || n == 1) {
            return n;
        }
        f = new int[n][n];
        int i, j; 
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                f[i][j] = -1;
            }
        }
        calc(0, n - 1);
        return f[0][n-1];
        
    }
}