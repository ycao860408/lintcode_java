public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    int n; 
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int nn) {
        // write your code here
        n = nn;
        dfs(0,0, "");
        return res;
        
    }
    private void dfs(int nleft, int nright, String cur) {
        if (nleft == n && nright == n) {
            res.add(cur);
            return;
        }
        if (nleft < n) {
            dfs(nleft + 1, nright, cur + "(");
        }
        if (nright < n && nright < nleft) {
            dfs(nleft, nright + 1, cur + ")");
        }
    }
}