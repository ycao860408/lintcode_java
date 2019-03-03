public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int m = a.length, n = b.length;
        int f[][] = new int [m + 1][n + 1];
        
        for (int i = 1; i <= m ; i++ ) {
            for (int j = 1;j <= n; j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j - 1]);
                if (a[i-1] == b[j-1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        
        return f[m][n];
    }
}