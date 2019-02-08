public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    char[] s;
    int[] f;
    int n;
    public int numDecodings(String ss) {
        // write your code here
        s = ss.toCharArray();
        n = s.length;
        if (n == 0) {
            return 0;
        }
        
        f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        
        calc(n);
        return f[n];
    }
    
    private void calc(int i) {
        if (f[i] != -1) {
            return;
        }
        
        if (i == 0) {
            f[i] = 1;
            return;
        }
       
        calc(i - 1);
        if (i > 1) {
            calc(i - 2);
        }
        f[i] = 0;
        if (s[i - 1] >= '1') {
            f[i] += f[i - 1];
        }
        if (i > 1) {
            int t = 10 * (s[i-2] - '0') + (s[i - 1] - '0');
            if (t >= 10 && t <= 26) {
                f[i] += f[i - 2];
            }
        }
        
    }
}