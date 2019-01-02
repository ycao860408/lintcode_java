public class Solution {
    /**
     * @param num1: An integer
     * @param num2: An integer
     * @param num3: An integer
     * @return: an interger
     */
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // write your code here
        int res = Integer.MIN_VALUE;
        res = Math.max(res, num1);
        res = Math.max(res, num2);
        res = Math.max(res, num3);
        return res;
    }
}