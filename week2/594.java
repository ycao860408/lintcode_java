public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public final int BASE = 10000000;
    public int strStr2(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        
        if (target.length() == 0) {
            return 0;
        }
        
        int m = target.length();
        if (m == 0) {
            return 0;
        }
        
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % BASE;
        }
        
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE; 
        }
        int hashCode = 0;
        
        for (int i = 0; i < source.length(); i++) {
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            // abc + d
            if (i < m - 1) {
                continue;
            }
            //    i
            // abcd - a
            if (i >= m) {
                hashCode = hashCode - (source.charAt(i- m) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }
            
            if (hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}