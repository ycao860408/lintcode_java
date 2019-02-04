public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int res = 0;
    int n;
    Set<Integer> dif = new HashSet<>();
    Set<Integer> sum = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    public int totalNQueens(int nn) {
        // write your code here
        n = nn;
        if (n < 0) {
            return 0;
        }
        
        search(0);
        return res;
    }
    
    private void search(int level) {
        if (level == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !dif.contains(level - i) && !sum.contains(level + i)) {
                col.add(i);
                dif.add(level - i);
                sum.add(level + i);
                search(level + 1);
                col.remove(i);
                dif.remove(level - i);
                sum.remove(level + i);
            }
        }
    }
}

// without global variable

public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        int[] res = new int[1];
        Set<Integer> dif = new HashSet<>();
        Set<Integer> sum = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        dfs(n, 0, res, dif, sum, col);
        return res[0];
    }
    
    private void dfs(int n, int level, int[] res, Set<Integer> dif, Set<Integer> sum, Set<Integer>col) {
        if (level == n) {
            res[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !dif.contains(level - i) && !sum.contains(level + i)) {
                col.add(i);
                dif.add(level - i);
                sum.add(level + i);
                dfs(n, level + 1, res, dif,sum, col);
                col.remove(i);
                dif.remove(level - i);
                sum.remove(level + i);
            }
        }
    }
}