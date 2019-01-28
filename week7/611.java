/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int [] dx = {1, 1, -1,-1, 2, 2, -2, -2};
        int [] dy = {2,-2, 2, -2, 1, -1, 1, -1};
        int ans = 0;
        Queue<Point> que = new LinkedList<>();
        boolean[][] v = new boolean[grid.length][grid[0].length];
        
        que.offer(source);
        v[source.x][source.y] = true;
        
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Point cur = que.poll();
                if (cur.x == destination.x && cur.y == destination.y) {
                    return ans;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !v[nx][ny] && !grid[nx][ny]) {
                        v[nx][ny] = true;
                        que.offer(new Point(nx, ny));
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}