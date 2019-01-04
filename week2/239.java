public class Solution {
    /*
     * @param a: parameter of the equation
     * @param b: parameter of the equation
     * @param c: parameter of the equation
     * @return: a double array, contains at most two root
     */
    public double[] rootOfEquation(double a, double b, double c) {
        // write your code here
        double [] res;
        double root1, root2;
        double delta = Math.pow(b, 2) - 4 * a * c;
        if ( delta > 0) {
            root1 = (-b - Math.sqrt(delta))/ (2*a);
            root2 = (-b + Math.sqrt(delta)) / (2*a);
            res = new double[2];
            res[0] = Math.min(root1, root2);
            res[1] = Math.max(root1, root2);
        } else if (delta < 0) {
            res = new double[0];
        } else {
            root1 = root2 = -b /(2* a);
            res = new double[1];
            res[0] = root1;
        }
        return res;
    }
}