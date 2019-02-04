public class Solution {
    /**
     * @param n: an integer, denote the number of courses
     * @param p: a list of prerequisite pairs
     * @return: return an integer,denote the number of topologicalsort
     */
     
    int n;
    boolean[][] pre;
    int[] preCnt; // indegree
    boolean[] done;
    int res;
    public int topologicalSortNumber(int nn, int[][] p) {
        // Write your code here
        n = nn;
        pre = new boolean[n][n];
        done = new boolean[n];
        preCnt = new int[n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                pre[i][j] = false; // i needs to be taken before j;
            }
        }
        
        for (int i = 0;i < n; i++) {
            preCnt[i] = 0;
            done[i] = false;
        }
        for (int i = 0; i < p.length; i++) {
            pre[p[i][1]][p[i][0]] = true;
            preCnt[p[i][0]]++;
        }
        dfs(0);
        return res;
    }
    
    private void dfs(int level) {
        if (level == n) {
            res++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!done[i] && preCnt[i] == 0) {
                done[i] = true;
                for (int j = 0; j < n;j++) {
                    if (pre[i][j] == true) {
                        preCnt[j]--;
                    }
                }
                dfs(level + 1);
                done[i] = false;
                for (int j = 0; j < n;j++) {
                    if (pre[i][j] == true) {
                        preCnt[j]++;
                    }
                }
            }
        }
    }
}