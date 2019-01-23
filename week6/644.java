public class Solution {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here
        Map<Character, Character> mirror = new HashMap<>();
        mirror.put('6','9');
        mirror.put('9','6');
        mirror.put('0','0');
        mirror.put('1','1');
        mirror.put('8','8');
        char[] scr = num.toCharArray();
        int i = 0, j = num.length() - 1;
        while ( i <= j) {
            if (!mirror.containsKey(scr[i])) {
                return false;
            }
            if (mirror.get(scr[i]) != scr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}