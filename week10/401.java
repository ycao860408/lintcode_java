public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int[] dx = {0,1};
        int[] dy = {1,0};
        int n = matrix.length; 
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, new PairComparator());
        minHeap.add(new Pair(0,0, matrix[0][0]));
        for (int i = 0; i < k - 1; i++) {
            Pair cur = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];
                if (nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    minHeap.offer(new Pair(nx, ny, matrix[nx][ny]));
                }
            }
        }
        return minHeap.peek().val;
    }
}

class Pair{
    int val, x,y; 
    Pair(int x, int y, int val) {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
    }
}