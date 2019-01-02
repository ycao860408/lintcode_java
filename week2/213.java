public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        if (originalString == null || originalString.isEmpty()) {
            return "";
        }
        String res = "";
        char [] chars = originalString.toCharArray();
        char val = chars[0];
        int count = 0;
        
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == val) {
                count++;
            } else {
                res = res + val + count;
                count = 1; 
                val = chars[i];
            }
        }
        res = res + val + count;
        
        if (res.length() >= originalString.length()) {
            return originalString;
        }
        return res;
    }
}