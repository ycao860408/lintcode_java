public class Solution {
    /**
     * @param m: the row
     * @param n: the column
     * @return: the possible unique paths
     */
     
    int m, n; 
    int res = 0;
    boolean[][] done;
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0,0, 1, -1};
    
    public int uniquePaths(int mm, int nn) {
        // Write your code here
        m = mm; n = nn;
        done = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                done[i][j] = false;
            }
        }
        done[0][0] = true;
        dfs(0,0);
        return res;
    }
    
    private void dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            res++;
            return;
        }
       
        for (int i = 0; i < 4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >=0 && nx < m && ny >=0 && ny < n && !done[nx][ny]) {
                done[nx][ny] = true;
                dfs(nx, ny);
                done[nx][ny] = false;
            }
        }
    }
}