public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0 ) {
            return 0;
        }
        int res = 0;
        boolean[][] v = new boolean [grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] && !v[i][j]) {
                    bfs(grid, v, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void bfs(boolean[][] grid, boolean[][] v, int sx, int sy) {
        int [] dx = {0,0,1,-1};
        int [] dy = {1, -1, 0,0};
        
        Queue<Integer> qx  = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        v[sx][sy] = true;
        qx.offer(sx);
        qy.offer(sy);
         while (!qx.isEmpty() && !qy.isEmpty()) {
             int cx = qx.poll();
             int cy = qy.poll();
             for (int i = 0; i < 4; i++) {
                 int nx = cx + dx[i];
                 int ny = cy + dy[i];
                 if (nx>= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] && !v[nx][ny]) {
                     qx.add(nx);
                     qy.add(ny);
                     v[nx][ny] = true;
                 }
             }
         }
    }
}