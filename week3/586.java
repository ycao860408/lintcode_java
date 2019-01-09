\\public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
        double left = 0, right = Math.max(1,x), epxilon = 1e-12;
        
        while (Math.abs(right - left) > epxilon) {
            double mid = left + (right - left) / 2;
            if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if ( Math.abs(left*left - x) < epxilon) {
            return left;
        }
        return right;
    }
}