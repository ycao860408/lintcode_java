public class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
     
    int[] A ; 
    int T; 
    int n; 
    int[][] f;
    public int backPackV(int[] nums, int target) {
        // write your code here
        A = nums; 
        T = target;
        n = nums.length;
        f = new int[n + 1][T+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= T; j++) {
                f[i][j] = -1;
            }
        }
        calc(n, T);
        return f[n][T];
    }
    
    private void calc(int i , int j) {
        if (f[i][j] != -1) {
            return;
        }
        
        if (i == 0) {
            if (j == 0) {
                f[i][j] = 1;
            } else {
                f[i][j] = 0;
            }
            return;
        }
        f[i][j] = 0;
        calc(i - 1, j);
        f[i][j] += f[i - 1][j];
        if (j >= A[i - 1]) {
            calc(i - 1, j - A[i - 1]);
            f[i][j] += f[i - 1][j - A[i - 1]];
        }
    }
}