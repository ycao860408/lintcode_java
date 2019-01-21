public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        if (source == null || target == null || source.length() == 0 || target.length() == 0 || target.length() > source.length()) {
            return "";
        }
        
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        int k = 0;
        for (char item : t) {
            targetHash[item]++;
            if (targetHash[item] == 1)
                k++;
        }
        int curusize = 0;
        int awsl = -1, awsr = -1, miniSize = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < s.length; r++) {
            if (targetHash[s[r]] != 0) {
                sourceHash[s[r]]++;
                if (targetHash[s[r]] == sourceHash[s[r]]) {
                    curusize++;
                }
            }
            while (curusize == k) {
                if (r - l + 1 < miniSize) {
                    awsl = l;
                    awsr = r;
                    miniSize = r - l + 1;
                }
                if (targetHash[s[l]] != 0) {
                    sourceHash[s[l]]--;
                    if (sourceHash[s[l]]==(targetHash[s[l]] - 1)){
                        curusize--;
                    }
                }
                l++;
            }
        }
        if (awsr == -1 && awsl == -1) {
            return "";
        }
        return source.substring(awsl, awsr+ 1);
    }
}