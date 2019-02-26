public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    char[][] pattens = {{'(',')'},{')','('}};
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, pattens[0], res);
        return res;
    }
    
    private void dfs(String s, int start, int lastRemove, char[] pattern, List<String> res) {
        int cnt = 0, n = s.length();
        for (int i = start; i < n; i++) {
            if (s.charAt(i) == pattern[0]) {
                cnt++;
            } 
            
            if (s.charAt(i) == pattern[1]) {
                cnt--;
            } 
            
            if (cnt < 0) {
                for (int j = lastRemove ; j <= i ; j++) {
                    if (s.charAt(j) == pattern[1] && (j == lastRemove || s.charAt(j) != s.charAt(j - 1))) {
                        dfs(s.substring(0,j) + s.substring(j + 1), i, j, pattern, res);
                    }
                }
                return;
            }
        }
        s = new StringBuilder(s).reverse().toString();
        if (pattern[0] == pattens[0][0]) {
            dfs(s, 0, 0, pattens[1], res);
        } else {
            res.add(s);
        }
    }
}