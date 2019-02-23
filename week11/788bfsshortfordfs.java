public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int m = maze.length, n = maze[0].length;
        int [][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start[0],start[1],0));
        int[] dirs = {-1,0,1,0,-1};
        while (!que.isEmpty()) {
            Point cur = que.poll();
            if (cur.l >= res[cur.x][cur.y]) {
                continue;
            }
            res[cur.x][cur.y] = cur.l;
            for (int k = 0; k < 4; k++) {
                int x = cur.x, y = cur.y, l = cur.l; 
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
                    x += dirs[k];
                    y += dirs[k + 1];
                    l++;
                }
                x -= dirs[k];
                y-= dirs[k + 1];
                l--;
                que.offer(new Point(x, y, l));
            }
            
        }
        
        return res[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : res[destination[0]][destination[1]];
        
    }
}

class Point{
    int x, y, l;
    Point(int x, int y, int l) {
        this.x = x; 
        this.y = y;
        this.l = l;
    }
}