public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null) {
            return 0;
        }
        int [] cnt = new int[256];
        char [] scr = s.toCharArray();
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            cnt[scr[r]]++;
            while (cnt[scr[r]] > 1) {
                cnt[scr[l]] --;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}