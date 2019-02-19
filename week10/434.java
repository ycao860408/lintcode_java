public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
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
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return null;
        }
        father = new int[m * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                father[i * m + j] = i * m + j;
            }
        }
        boolean island[][] = new boolean[n][m];
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x;
            int y = operators[i].y;
            if (island[x][y]) {
                res.add(size);
                continue;
            } 
            island[x][y] = true;
            size++;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && island[nx][ny]) {
                    union(x * m + y, nx * m + ny);
                }
            }
            res.add(size);
        }
        return res;
    }
}