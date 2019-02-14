public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0 || costs[0].length < 2) {
            return 0;
        }
        
        int m = costs.length, n = costs[0].length;
        int[][] states = new int[m + 1][n];
        
        for (int i = 0; i < n; i++) {
            states[0][i] = 0;
        }
        int first = 0, second = 1;
        for (int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if (j != first) {
                    states[i][j] = states[i - 1][first] + costs[i-1][j];
                } else {
                    states[i][j] = states[i - 1][second] + costs[i-1][j];
                }
            }
            if (i != m) {
                Pair firstSecond = getFirstSecond(states,i);
                first = firstSecond.first;
                second = firstSecond.second;
                System.out.println(first + " " + second);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, states[m][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private Pair getFirstSecond(int[][] costs, int i) {
        int first = 0, second = 1; 
        if (costs[i][first] > costs[i][second]) {
            second = 0; 
            first = 1;
        }
        for (int j =  2; j < costs[i].length; j++) {
            if (costs[i][j] < costs[i][first]) {
                second = first;
                first = j;
            } else if (costs[i][j] >= costs[i][first] && costs[i][j] < costs[i][second]) {
                second = j;
            } else {
                continue;
            }
        }
        return new Pair(first, second);
    }
}
class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second;
    }
}