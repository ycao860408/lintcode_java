public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.min(ans, bfs(grid, i, j));
                }        
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int bfs(int[][] grid, int sx, int sy) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean [][] v = new boolean[grid.length][grid[0].length];
        
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        qx.offer(sx);
        qy.offer(sy);
        v[sx][sy] = true;
        
        int dist = 0;
        int sum = 0;
        while (!qx.isEmpty()) {
            dist++;
            int size = qx.size();
            for (int i = 0; i < size; i++) {
                int cx = qx.poll();
                int cy = qy.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !v[nx][ny]){
                        v[nx][ny] = true;
                        if (grid[nx][ny] == 1) {
                            sum += dist;
                        }
                        if (grid[nx][ny] == 0) {
                            qx.offer(nx);
                            qy.offer(ny);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !v[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        
        return sum;
    }
}