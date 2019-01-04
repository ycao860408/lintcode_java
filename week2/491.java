public class Solution {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        String numstr = new String(Integer.toString(num));
        int i = 0, j = numstr.length() - 1;
        
        while (i < j) {
            if (numstr.charAt(i) != numstr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}