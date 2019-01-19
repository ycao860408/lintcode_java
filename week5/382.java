public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] s) {
        // write your code here
        if (s == null || s.length < 3) {
            return 0;
        }
        int ans = 0, num = s.length;
        Arrays.sort(s);
        for (int i = num - 1; i >= 2; i--) {
            ans += twoSum(s, s[i], i );
        }
        return ans;
    }
    
    private int twoSum(int [] s, int target, int right) {
        int ans = 0; 
        for (int l = 0, r = right - 1; l < r; r--) {
            while (l < r && s[l] + s[r] <= target) {
                l++;
            }
                ans += (r - l);
        }
        return ans;
    }
}