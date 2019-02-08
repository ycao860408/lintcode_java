public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    int [] result;
    public int climbStairs(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        
        result = new int[n  + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = -1;
        }
        f(n);
        return result[n];
    }
    
    private void f(int n) {
        if (result[n] != -1) {
            return;
        }
        if (n == 0 || n == 1) {
            result[n] = 1;
            return;
        }
        f(n - 1);
        f(n - 2);
        result[n] = result[n - 1] + result[n - 2];
    }
}