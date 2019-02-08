public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int m = costs.length, n = costs[0].length;
        int[][] states = new int[m + 1][n];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0 ; j < n; j++) {
                states[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < n; i++) {
            states[0][i] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                for (int k = j + 1; k%n != j; k++) {
                    states[i][j] = Math.min(states[i][j], states[i - 1][k%n] + costs[i-1][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, states[m][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}