public class Solution {
    /**
     * @param n: a Integer
     * @return: a spiral array
     */
    public int[][] spiralArray(int n) {
        // write your code here
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int x = 0, y = 0;
        int d = 0;
        for (int i = 1; i <= n * n ; i++) {
            res[x][y] = i;
            int nx =  x + dx[d], ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >=n || res[nx][ny] != -1) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            x = nx; 
            y = ny;
            
        }
        return res;
    }
}