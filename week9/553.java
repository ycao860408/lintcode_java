public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        int [][] up = new int[m][n];
        int [][] down = new int[m][n];
        int [][] left = new int[m][n];
        int [][] right = new int[m][n];
        
        for (int i = 0;i < m; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = 0; 
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        up[i][j] = 1;
                    }
                    if (i >= 1) {
                        up[i][j] += up[i-1][j];
                    }
                }
            }
        }
        
        for (int i = m -1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                down[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        down[i][j] = 1;
                    }
                    if ( i <= m - 2) {
                        down[i][j] += down[i+ 1][j];
                    }
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                left[i][j] = 0;
                if (grid[i][j]!='W') {
                    if (grid[i][j] == 'E') {
                        left[i][j] = 1;
                    }
                    if (j >= 1) {
                        left[i][j] += left[i][j - 1];
                    }
                }
            }
        }
        
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                right[i][j] = 0;
                if (grid[i][j]!='W') {
                    if (grid[i][j] == 'E') {
                        right[i][j] = 1;
                    }
                    if (j <= n - 2) {
                        right[i][j] +=  right[i][j + 1];
                    }
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, left[i][j] + right[i][j] + up[i][j] + down[i][j]);
                }
            }
        }
        
        return ans;
    }
    
}