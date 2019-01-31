public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(String str, int index, List<String> cur, List<List<String>> res) {
        if (index == str.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
       
        cur.add(str.charAt(index) +"");
        dfs(str, index + 1, cur, res);
        cur.remove(cur.size() - 1);
        
        if (index + 1 < str.length()) {
            cur.add(str.substring(index, index + 2));
            dfs(str, index +2, cur, res);
            cur.remove(cur.size() - 1);
        }
        
    }
}