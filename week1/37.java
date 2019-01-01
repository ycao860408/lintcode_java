public class Solution {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        int res = 0;
        while (number != 0) {
            int dig = number % 10;
            number /= 10;
            res = res * 10 + dig;
        }
        return res;
    }
}