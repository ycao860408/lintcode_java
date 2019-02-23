public class Solution {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        for (int i = 0; i < n; i++) {
            if (t1[i] != t2[i]) {
                return false;
            }
        }
        
        
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i),s2.substring(0, i)) &&
            isScramble(s1.substring(i, n),s2.substring(i , n)) ||
            isScramble(s1.substring(0, i), s2.substring(n - i, n)) &&
            isScramble(s1.substring(i, n), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
}

//  把比较那边的循环给换了。
public class Solution {
    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        /*for (int i = 0; i < n; i++) {
            if (t1[i] != t2[i]) {
                return false;
            }
        }
        */
        if (!Arrays.equals(t1, t2)) {
            return false;
        }
        
        
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i),s2.substring(0, i)) &&
            isScramble(s1.substring(i, n),s2.substring(i , n)) ||
            isScramble(s1.substring(0, i), s2.substring(n - i, n)) &&
            isScramble(s1.substring(i, n), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
}