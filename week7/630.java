public class Solution {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        
        if (grid[0][0] || grid[m - 1][n - 1]) {
            return -1;
        }
        
        if (m == 1 && n == 1) {
            return 0;
        }
        
        Queue<Integer> qa = new LinkedList<>();
        boolean [][] va = new boolean[m][n];
        qa.offer(0);
        va[0][0] = true;
        Queue<Integer> qb = new LinkedList<>();
        boolean [][] vb = new boolean[m][n];
        qb.offer((m * n - 1));
        vb[m - 1][n - 1] = true;
        
        Queue<Integer> queCur = null;
        boolean [][] vCur = null, vOp = null;
        int step = 0, sign = 1;
        int [] dx = {1, -1, 2, -2};
        int[] dy = {2, 2, 1, 1};
        while (!qa.isEmpty() && !qb.isEmpty()) {
            step++;
            int s1 = qa.size();
            int s2 = qb.size();
            if (s1 <= s2) {
                queCur = qa;
                vCur = va;
                vOp = vb;
                sign = 1;
            }else {
                queCur = qb;
                vCur = vb;
                vOp = va;
                sign = -1;
            }
            int size = Math.min(s1,s2);
            for (int i = 0; i < size; i++) {
                int cur = queCur.poll();
                int cx = cur / n;
                int cy = cur % n;
                for (int j = 0; j < 4; j++) {
                    int nx = cx + sign * dx[j];
                    int ny = cy + sign * dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !grid[nx][ny]) {
                        if (vOp[nx][ny]){
                            return step;
                        }
                        
                        if (!vCur[nx][ny]) {
                            queCur.offer(nx * n + ny);
                            vCur[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}