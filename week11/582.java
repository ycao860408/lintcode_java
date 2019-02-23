public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> res = new ArrayList<>();
        Map<String, List<String>> memo = new HashMap<>();
        memo.put("", new ArrayList<>());
        memo.get("").add("");
        return dfs(s, wordDict, memo);
    }
    
    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> ans = new ArrayList<>();
        
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0,i);
            String s2 = s.substring(i, s.length());
            if (wordDict.contains(s1)) {
                List<String> s2_res = dfs(s2, wordDict, memo);
                for (String item : s2_res) {
                    if (item.equals("")) {
                        ans.add(s1);
                    } else {
                        ans.add(s1 + " " + item);
                    }
                }
            }
        }
        memo.put(s, ans);
        return ans;
    }
}