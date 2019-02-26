public class Solution {
    /**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // write your code here
        if (n <=2) return 0;
        int res = 0;
        for(int i = 2; i < n; i++) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (i > n / i) {
                break;
            }
            if (n % i == 0 ) {
                return false;
            }
        }
        return true;
    }
}