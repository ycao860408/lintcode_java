public class Solution {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
     
    
    public boolean isScramble(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        if (m != n) {
            return false;
        }
        
        boolean[][][] f = new boolean[n][n][n + 1];
        int i, j, w, k;
        for (i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                f[i][j][1] = S.charAt(i) == T.charAt(j);
                
            }
        }
        
        for (k = 2; k <= n; k++) {
            for ( i = 0; i <= n - k ; i++) {
                for(j = 0; j <= n - k; j++) {
                    f[i][j][k] = false;
                    for (w = 1; w < k ; w++) {
                        if (f[i][j][w] && f[i + w][j + w][k - w]) {
                            f[i][j][k] = true;
                            break;
                        }
                        
                        if (f[i][j + k - w][w] && f[i + w][j][k - w]) {
                            f[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }
}