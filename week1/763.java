public class Solution {
    /**
     * @param n: a decimal number
     * @param k: a Integer represent base-k
     * @return: a base-k number
     */
    public String hexConversion(int n, int k) {
        // write your code here
        String res = "";
       
        if (n == 0) 
            res = "0";
        while (n != 0) {
            char ch = '0';
            int dig = n % k;
            n /= k;
            if ( dig >= 10) 
                ch = (char)('A' + (dig - 10));
            else{
                ch = (char)(ch + (dig - 0));
            }
            res = ch + res;
        }
        return res;
    }
}