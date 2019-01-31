public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
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
        
        for (int i = index; i < str.length(); i++) {
            String subStr = str.substring(index, i + 1);
            if (isPalin(subStr)){
                cur.add(subStr);
                dfs(str, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPalin(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++; 
            j--;
        }
        return true;
    }
    
    
}