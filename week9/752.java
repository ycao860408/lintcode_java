public class Solution {
    /**
     * @param n: the max identifier of planet.
     * @param m: gold coins that Sven has.
     * @param limit: the max difference.
     * @param cost: the number of gold coins that reaching the planet j through the portal costs.
     * @return: return the number of ways he can reach the planet n through the portal.
     */
    int n, m, limit;
    int[] cost; 
    long[][] f;
    public long getNumberOfWays(int nn, int mm, int llimit, int[] ccost) {
        // 
        n = nn; 
        m = mm; 
        limit = llimit;
        cost = ccost;
        f = new long[n + 1][m + 1];
        int i, j; 
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                f[i][j] = -1;
            }
        }
        
        long res = 0; 
        
        for (i = 0; i <= m; ++i) {
            calc(n, i);
            res += f[n][i];
        }
        return res;
    }
    
    private void calc(int i, int j) {
        if(f[i][j] != -1) {
            return;
        }
        
        if (i == 0) {
            if (j == m) {
                f[i][j] = 1;
            } else {
                f[i][j] = 0;
            }
            return;
        }
        f[i][j] = 0;
        
        for (int k = i - limit; k < i; k++) {
            if (k < 0) {
                continue;
            }
            if (j + cost[i] <= m) {
                calc(k, j + cost[i]);
                f[i][j] += f[k][j + cost[i]];
            }
        }
    }
}