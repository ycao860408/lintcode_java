public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null) {
            return false;
        }
        
        int i = 0, j = s.length() - 1;
        String ls = s.toLowerCase();
        while (i < j) {
            while (i < j && !valid(ls.charAt(j))) {
                j--;
            }
            
            while (i < j && !valid(ls.charAt(i))) {
                i++;
            }
            
            if (ls.charAt(i) == ls.charAt(j)) {
                j--;
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean valid(char ch) {
        return Character.isLetterOrDigit(ch);
    }
}