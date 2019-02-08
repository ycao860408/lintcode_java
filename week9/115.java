public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] A) {
        // write your code here
        if (A == null || A.length == 0 || A[0].length == 0 || A[0][0] == 1) {
            return 0;
        }
        
        int m = A.length, n = A[0].length;
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = A[0][i] == 1 ? 0 : dp[0][i - 1];
        }
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = A[i][0] == 1 ? 0 : dp[i-1][0];
        }
        
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = A[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

// dfs 超时间做法

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] A) {
        // write your code here
        if (A == null || A.length == 0 || A[0].length == 0 || A[0][0] == 1) {
            return 0;
        }
        
        int m = A.length, n = A[0].length;
        
        return dfs(A, m-1, n - 1);
    }
    
    private int dfs(int[][] A, int x, int y) {
        if (A[x][y] == 1) {
            return 0;
        }
        
        if (x == 0 && y == 0) {
            return 1;
        }
        
        if (x == 0) {
            return dfs(A, x, y-1);
        }
        
        if (y == 0) {
            return dfs(A, x -1, y);
        }
        
        return dfs(A, x -1, y) + dfs(A, x, y - 1);
    }
}

// 记忆化搜索 

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] A) {
        // write your code here
        if (A == null || A.length == 0 || A[0].length == 0 || A[0][0] == 1) {
            return 0;
        }
        
        int m = A.length, n = A[0].length;
        int dp[][] = new int [m][n];
        for (int i = 0;i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(A, m-1, n - 1, dp);
    }
    
    private int dfs(int[][] A, int x, int y, int[][] dp) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        } 
        if (A[x][y] == 1) {
            dp[x][y] = 0;
            return 0;
        }
        
        if (x == 0 && y == 0) {
            dp[x][y] = 1;
            return 1;
        }
        
        if (x == 0) {
            dp[x][y] = dfs(A, x, y-1, dp);
            return dp[x][y];
        }
        
        if (y == 0) {
            dp[x][y] = dfs(A, x -1, y, dp);
            return dp[x][y];
        }
        
        dp[x][y] =  dfs(A, x -1, y, dp) + dfs(A, x, y - 1, dp);
        return dp[x][y];
    }
}