public class Solution {
    /**
     * @param S: a string
     * @return: return a list of strings
     */
    List<String> res = new ArrayList<>();
    private void dfs(char[] s, int index, String cur){
        if (index == s.length) {
            res.add(cur);
            return;
        }
        if(s[index] >= '0' && s[index] <= '9') {
            dfs(s, index + 1, cur + s[index]);
        } else {
            char temp;
            if (s[index] >= 'a' && s[index]<= 'z') {
                temp = (char)(s[index]- 32);
            } else {
                temp = (char)(s[index] + 32);
            }
            dfs(s, index + 1, cur + s[index]);
            dfs(s, index + 1, cur + temp);
        }
        
        
    }
    public List<String> letterCasePermutation(String S) {
        // write your code here
        char[] scr = S.toCharArray();
        dfs(scr, 0, "");
        return res;
    }
}