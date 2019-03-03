public class Solution {
    /**
     * @param n: a integer
     * @return: return a string
     */
    public String convertToTitle(int n) {
        // write your code here
        String res = "";
        while (n != 0) {
            n--;
            int dig = n % 26;
            n /= 26;
            res =  (char)(dig + 'A')+res;
        }
        return res;
    }
}