public class Solution {
    /*
     * @param str: a string
     * @return: Return a hash map
     */
    public Map<Character, Integer> countCharacters(String str) {
        // write your code here
        Map<Character, Integer> res = new HashMap<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char [] scr = str.toCharArray();
        for (char item : scr) {
            if (!res.containsKey(item)) {
                res.put(item, 0);
            } 
            res.put(item, res.get(item) + 1);
        }
        return res;
    }
}