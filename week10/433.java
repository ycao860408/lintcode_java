public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
     
    int father[] = null;
    int size;
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    private void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        if (root_x != root_y) {
            father[root_x] = root_y;
            size--;
        }
    }
    
    public int numIslands(boolean[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        father = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    size++;
                    father[i * n + j] = i * n + j;
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dirs[k][0];
                        int y = j + dirs[k][1];
                        if (x < m && x >= 0 && y < n && y >= 0 && grid[x][y]) {
                            union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        return size;
    }
}