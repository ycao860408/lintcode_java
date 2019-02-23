public class Solution {
    /**
     * @param maze: the maze
     * @param ball: the ball position
     * @param hole: the hole position
     * @return: the lexicographically smallest way
     */
    class Point {
        int x, y, l; 
        String path;
        Point(int x, int y, int l, String path) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.path = path;
        }
        
        public boolean isLess(Point p) {
            if (this.l < p.l || (this.l == p.l && this.path.compareTo(p.path) < 0)) {
                return true;
            }
            return false;
        }
    }
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        // write your code here
        int m = maze.length, n = maze[0].length;
        Point [][] res =  new Point[m][n];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = new Point(i, j, Integer.MAX_VALUE, "");
            }
        }
        int[] dirs= {-1, 0 , 1, 0, -1};
        String [] dirStrs = {"u", "r", "d", "l"};
        Queue <Point> que = new LinkedList<>();
        que.offer(new Point(ball[0], ball[1], 0, ""));
        while (!que.isEmpty()) {
            Point cur = que.poll();
            if (!cur.isLess(res[cur.x][cur.y])) {
                continue;
            }
            res[cur.x][cur.y] = cur;
            if (cur.x == hole[0] && cur.y == hole[1]) {
                continue;
            }
            
            for (int k = 0; k < 4; k++) {
                int x = cur.x, y = cur.y, l = cur.l;
                while (x >= 0 && y >=0 && x < m && y < n && maze[x][y] != 1 && (x != hole[0] || y != hole[1])) {
                    x += dirs[k];
                    y += dirs[k + 1];
                    l++;
                }
                if (x != hole[0] || y != hole[1]) {
                    x-= dirs[k];
                    y-= dirs[k + 1];
                    l--;
                }
                que.offer(new Point(x, y, l, cur.path + dirStrs[k]));
            }
        }
        return res[hole[0]][hole[1]].l == Integer.MAX_VALUE ? "impossible" : res[hole[0]][hole[1]].path;
    }
    
}