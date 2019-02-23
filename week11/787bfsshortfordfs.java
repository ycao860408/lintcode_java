public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int m = maze.length, n = maze[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Integer> que = new LinkedList<>();
        que.add(start[0] *n + start[1]);
        visited[start[0]][start[1]] = true;
        int[] dirs = {-1,0,1,0,-1};
        while (!que.isEmpty()) {
            int cur = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = cur / n;
                int y = cur % n;
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
                    x += dirs[i];
                    y += dirs[i + 1];
                }
                x -= dirs[i];
                y-= dirs[i + 1]; 
                if (x == destination[0] && y == destination[1]) {
                    return true;
                }
                if (!visited[x][y]) {
                    que.offer(x * n + y);
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}