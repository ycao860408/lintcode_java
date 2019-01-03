public class Solution {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
       
        boolean found = false;
        int i;
        for (i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (target.charAt(j) != source.charAt(i + j)) {
                    break;
                }
            }
            if (j == target.length()) {
                found = true;
                break;
            }
        }
        if (found) {
            return i;
        } else {
            return -1;
        }
    }
}