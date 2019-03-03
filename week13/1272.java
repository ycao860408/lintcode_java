class Pair {
    int val, x, y; 
    Pair(int val, int x, int y) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair e1, Pair e2) {
        return e1.val - e2.val;
    }
}
public class Solution {
    /**
     * @param matrix: List[List[int]]
     * @param k: a integer
     * @return: return a integer
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int[] dx = {0,1};
        int[] dy = {1,0};
        int n = matrix.length; 
        int m = matrix[0].length;
        boolean[][] visited = new boolean [n][m];
        PriorityQueue<Pair> que = new PriorityQueue(k, new PairComparator());
        que.offer(new Pair(matrix[0][0], 0, 0));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Pair cur = que.poll();
            for (int j = 0; j < 2; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if (nx < n && ny < m && !visited[nx][ny]) {
                    que.offer(new Pair(matrix[nx][ny], nx, ny));
                    visited[nx][ny] = true;
                }
            }
            
        }
        return que.poll().val;
    }
}