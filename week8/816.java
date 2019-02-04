public class Solution {
    /**
     * @param n: an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
     
    int n; 
    int[][] g;
    boolean [] done;
    int res = Integer.MAX_VALUE;
    
    public int minCost(int nn, int[][] costs) {
        // Write your code here
        n = nn;
        int i, j, x, y;
        g = new int[n][n];
        for (i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                g[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (i = 0; i < costs.length; i++) {
            x = costs[i][0] - 1;
            y = costs[i][1] - 1;
            g[x][y] = Math.min(g[x][y], costs[i][2]);
            g[y][x] = Math.min(g[y][x], costs[i][2]);
        }
        
        done = new boolean[n];
        for (i = 0; i < n; i++) {
            done[i] = false;
        }
        done[0] = true;
        
        dfs(1,0,0);
        
        return res;
    }
    
    void dfs(int level, int p, int c) {
        if (c >= res) {
            return;
        }
        if (level == n) {
            if (c < res) {
                res = c;
            }
            return;
        }
        int i;
        for (i = 0; i < n; i++) {
            if (!done[i] && g[p][i] != Integer.MAX_VALUE) {
                done[i] = true;
                dfs(level + 1, i,c + g[p][i]);
                done[i] = false;
            }
        }
    }
}