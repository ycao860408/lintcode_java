public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // write your code here
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int r = board.length ;
        int c = board[0].length;
        Set<Integer> bound = new HashSet();
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                if (!bound.contains(0 * c + i)) {
                    bound.add(0 * c + i);
                    bfs(board, 0, i, bound);
                }
            }
            if (board[r - 1][i] == 'O') {
                if(!bound.contains((r -1 ) * c + i)) {
                    bound.add((r - 1) * c + i);
                    bfs(board, r - 1, i, bound);
                }
            }
        }
        
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == 'O') {
                if (!bound.contains(i * c + 0)) {
                    bound.add(i * c + 0);
                    bfs(board, i, 0, bound);
                }
            }
            if (board[i][c - 1] == 'O') {
                if (!bound.contains(i * c + (c - 1))) {
                     bound.add(i * c + (c - 1));
                     bfs(board, i, c - 1, bound);
                }
            }
        }
        /*
        for (Integer item : bound) {
            System.out.println(item);
        }
        */
        
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !bound.contains(i * c + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int sx, int sy, Set<Integer> bound) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(sx);
        qy.offer(sy);
        
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        while (!qx.isEmpty() && !qy.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < board.length && ny >=0 && ny < board[0].length && board[nx][ny] == 'O') {
                    if (!bound.contains(nx * board[0].length + ny)) {
                        bound.add(nx * board[0].length + ny);
                        qx.offer(nx);
                        qy.offer(ny);
                    }
                }
            }
        }
    }
}