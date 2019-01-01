public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String reverseString(String s) {
        // write your code here
        String res = "";
        for (int i = s.length() - 1; i >=0; i--) {
            res = res + s.charAt(i);
        }
        return res;
    }
}