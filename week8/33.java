public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        if (n == 0) {
            return null;
        }
        List<List<String>> res = new ArrayList<>();
        Set<Integer> sum = new HashSet<>();
        Set<Integer> dif = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        dfs(n, 0, dif, sum, col, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int n, int level, Set<Integer> dif, Set<Integer> sum, Set<Integer>col, List<String> cur, List<List<String>> res) {
        if (level == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !sum.contains(level + i) && !dif.contains(level - i)) {
                dif.add(level - i);
                sum.add(level + i);
                col.add(i);
                cur.add(generate(n,i));
                dfs(n, level + 1, dif, sum, col, cur, res);
                dif.remove(level - i);
                sum.remove(level + i);
                col.remove(i);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private String generate(int n, int i) {
        char[] scr = new char[n];
        for(int j = 0; j < n; j++) {
            if (j == i) {
                scr[j] = 'Q';
            } else {
                scr[j] = '.';
            }
        }
        return new String(scr);
    }
}


//  using the global variable. 
public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
     
    List<List<String>> res = new ArrayList<>();
    char[][] board= null;
    Set<Integer> sum = new HashSet<>();
    Set<Integer> dif = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        if (n == 0) {
            return null;
        }
        board = new char[n][n];
        int i, j;
        for (i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        search(0, n);
        return res;
    }
    
    private void search(int level, int n) {
        if (level == n) {
            List<String> now = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                now.add(String.valueOf(board[i]));
            }
            res.add(now);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && ! sum.contains(level + i) && !dif.contains(level - i)) {
                col.add(i);
                sum.add(level + i);
                dif.add(level - i);
                board[level][i] = 'Q';
                search( level + 1, n);
                col.remove(i);
                sum.remove(level + i);
                dif.remove(level - i);
                board[level][i] = '.';
             }
        }
    }
}