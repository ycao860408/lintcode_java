public class Solution {
    /**
     * @param n: the given number
     * @return:  the double factorial of the number
     */
    public long doubleFactorial(int n) {
        // Write your code here
        long res = 1; 
        if (n == 0) return -1;
        while (n > 0) {
            res *= n;
            n-= 2;
        }
        return res;
    }
}