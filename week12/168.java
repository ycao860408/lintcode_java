public class Solution {
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] AA) {
        // write your code here
        int n = AA.length;
        if (n == 0) {
            return 0;
        }
        
        int [] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            A[i] = AA[i - 1];
        }
        n+= 2;
        int[][] f = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            f[i][i + 1] = 0;
        }
        
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                f[i][j] = 0;
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + A[i]*A[j] * A[k]);
                }
            }
        }
        return f[0][n - 1];
    }
}