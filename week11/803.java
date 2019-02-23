public class Solution {
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length, step  = 0, res = 0;
        int [][] totalDis = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for ( int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = bfs(grid, i, j, step, totalDis);
                    step--;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int bfs(int[][] grid, int x, int y, int step, int [][] totalDis) {
        int m = grid.length, n = grid[0].length;
        Queue<Integer> que = new LinkedList<>();
        int curDist = 0, res = Integer.MAX_VALUE;
        int[] dirs = {-1, 0, 1, 0, -1};
        que.offer(x * n + y);
        
        while (!que.isEmpty()) {
            curDist++;
            int l = que.size();
            for ( int i = 0; i < l; i++) {
                int cur = que.poll();
                x = cur / n;
                y = cur % n;
                
                for (int k = 0; k < 4; k++) {
                    int nx = x + dirs[k];
                    int ny = y + dirs[k + 1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == step) {
                        que.offer(nx * n + ny);
                        totalDis[nx][ny] += curDist;
                        res = Math.min(res, totalDis[nx][ny]);
                        grid[nx][ny]--;
                    }
                }
            }
        }
        return res;
    }
}