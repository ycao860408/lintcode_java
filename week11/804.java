class Point{
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid: the 2D grid
     * @return: the number of distinct islands
     */
    public int numDistinctIslands2(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 1) {
                    List<Point> island = new ArrayList<>();
                    dfs(grid, i, j, island);
                    res.add(getUnique(island));
                }
            }
        }
        return res.size();
    }
    
    private String getUnique(List<Point> island) {
        List<String> sameIslands = new ArrayList<>();
        int[][] trans = {{1,1},{1,-1},{-1,-1},{-1,1}};
        for (int k = 0; k < 4; k++) {
            List<Point> l1 = new ArrayList<>();
            List<Point> l2 = new ArrayList<>();
            for (Point p : island) {
                int x = p.x, y = p.y;
                l1.add(new Point(trans[k][0] * x, trans[k][1] * y));
                l2.add(new Point(trans[k][0] * y, trans[k][1] * x));
            }
            sameIslands.add(getStr(l1));
            sameIslands.add(getStr(l2));
        }
        Collections.sort(sameIslands);
        return sameIslands.get(0);
    }
    
    private String getStr(List<Point> island) {
        Collections.sort(island, new Comparator<Point>(){
            public int compare(Point a, Point b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                }
                return a.y - b.y;
            }
        });
        StringBuilder sb = new StringBuilder();
        int x = island.get(0).x, y = island.get(0).y;
        for (Point p : island) {
            sb.append((p.x - x) + " " + (p.y - y) + " ");
        }
        return sb.toString();
    }
    
    private void dfs(int[][] grid, int x, int y, List<Point> island) {
        int m = grid.length, n = grid[0].length;
        grid[x][y] = 0;
        island.add(new Point(x, y));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0,0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                dfs(grid, nx, ny, island);
            }
        }
    }
}