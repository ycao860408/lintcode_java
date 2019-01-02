public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        
        int [] scount = new int [256];
        int [] tcount = new int [256];
        
        for (int i = 0; i < s.length(); i++) {
            scount[(int)s.charAt(i)]++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            tcount[(int)t.charAt(i)]++;
        }
        
        boolean result = true;
        
        for ( int i = 0; i < 256; i++) {
            if (scount[i] != tcount[i]) {
                result = false;
                break;
            }
        }
        
        return result;
        
    }
}