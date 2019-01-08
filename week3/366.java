public class Solution {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    int [] fib;
    public int fibonacci(int n) {
        // write your code here
        fib = new int[n + 1];
        for (int i = 0; i < fib.length; i++) {
            fib[i] = -1;
        }
        return cal(n);
    
    }
    private int cal(int n) {
        if (fib[n] != -1) {
            return fib[n];
        }
        if (n == 1) return 0;
        if (n == 2) return 1;
        fib[n] = cal(n - 1) + cal(n - 2);
        return fib[n];
    }
}