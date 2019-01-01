public class Solution {
    /**
     * @param r: a Integer represent radius
     * @return: the circle's circumference nums[0] and area nums[1]
     */
    final double PI = 3.14;
    public double[] calculate(int r) {
        // write your code here
        double [] res = new double [2];
        res[0] = 2 * PI * r;
        res[1] = PI* r * r;
        return res;
    }
}