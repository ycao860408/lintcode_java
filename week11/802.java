public class Solution {
    /**
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    boolean [][] row = new boolean[9][10];
    boolean [][] col = new boolean[9][10];
    boolean [][][] block = new boolean[3][3][9+1];
    boolean ans;
    public void solveSudoku(int[][] board) {
        // write your code here
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    int item = board[i][j];
                    row[i][item] = true;
                    col[j][item] = true;
                    block[i / 3][j / 3][item] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }
    
    private void dfs(int[][] board, int i, int j) {
         if (i == 9) {
            ans = true;
            return;
        }
        
        if (j == 9) {
            dfs(board, i + 1, 0);
            return;
        }
        
        if (board[i][j] != 0) {
            dfs(board, i, j + 1);
            return;
        }
        
        
        for (int k = 1; k <= 9 ; k++) {
            if (!col[j][k] && !row[i][k] && !block[i/3][j/3][k]) {
                row[i][k] = col[j][k] = block[i/3][j/3][k] = true;
                board[i][j] = k;
                dfs(board, i, j + 1);
                if (ans == true) {
                    return;
                }
                board[i][j] = 0;
                row[i][k] = col[j][k] = block[i/3][j/3][k] = false;
                
            }
        }
    }
}