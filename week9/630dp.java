public class Solution {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0]) {
            return -1;
        }
        
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        
        for (int i = 0; i < m ; i++) {
            for (int j =0; j < n ; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        int[][] dirs = {{-1,-2},{1,-2},{-2,-1},{2,-1}};
        for(int j = 0; j < n; j++) {
            for (int i= 0 ; i < m; i++) {
                if (!grid[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dirs[k][0];
                        int y = j + dirs[k][1];
                        if (x >=0 && x < m && y >= 0 && y < n && dp[x][y] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[x][y] + 1);
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1] == Integer.MAX_VALUE ?  -1 : dp[m-1][n-1];
    }
}