public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    Map<String, List<String>> graph = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> lb = new HashMap<>();
    private List<String> getNext(String word, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] sc = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                sc[i] = c;
                String next = new String(sc);
                if (dict.contains(next) && !next.equals(word)) {
                    ret.add(next);
                }
            }
        }
        return ret;
    }
    
    private int getDiff(String a, String b) {
        int ret = 0; 
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ret++;
            }
        }
        return ret;
    }
    
    private void dfs(int limit, int x, String word, String end, List<String> path) {
        if (x == limit + 1) {
            if (word.equals(end)) {
                ans.add(new ArrayList(path));
            }
            return;
        }
        
        if (x - 1 + lb.get(word) > limit) {
            return;
        }
        
        for (String next: graph.get(word)) {
            path.add(next);
            dfs(limit, x + 1, next, end, path);
            path.remove(path.size() - 1);
        }
        
        if (ans.isEmpty()) {
            lb.put(word, Math.max(lb.get(word), limit - (x - 1) + 1 ));
        }
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        dict.add(start);
        dict.add(end);
        for (String word : dict) {
            graph.put(word, getNext(word, dict));
            lb.put(word, getDiff(word, end));
        }
        
        int limit = 0; 
        List<String> path = new ArrayList<>();
        path.add(start);
        while (ans.isEmpty()) {
            dfs(limit, 1, start, end, path);
            limit++;
        }
        return ans;
    }
}