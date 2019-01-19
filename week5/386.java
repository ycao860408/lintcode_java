public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null) {
            return 0;
        }
        int [] cnt = new int[256];
        char[] scr = s.toCharArray();
        int ans = 0, unum = 0;
        for (int r = 0, l = 0; r < s.length(); r++) {
            if(cnt[scr[r]] == 0) {
                unum++;
            }
            cnt[scr[r]]++;
            while (unum > k) {
                cnt[scr[l]]--;
                if (cnt[scr[l]] == 0) {
                    unum--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}