public class Solution {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    Map<String, List<String>> hash = new HashMap<>();
    List<String> path = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    
    private void initialPrefix(String[] words) {
        for (String  word : words) {
            hash.putIfAbsent("", new ArrayList<>());
            hash.get("").add(word);
            String prefix = "";
            for (char c : word.toCharArray()) {
                prefix += c;
                hash.putIfAbsent(prefix, new ArrayList());
                hash.get(prefix).add(word);
            }
        }
    }
    
    private boolean checkPrefix(int x, String nextWord, int l) {
        for (int i = x + 1; i < l; i++) {
            String prefix = "";
            for (String item : path) {
                prefix += item.charAt(i);
            }
            prefix += nextWord.charAt(i);
            if (!hash.containsKey(prefix)) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(int x, int l) {
        if (x == l) {
            ans.add(new ArrayList<>(path));
            return;
        }
        String prefix = "";
        for (String item: path) {
            prefix += item.charAt(x);
        }
        
        for (String  item : hash.get(prefix)) {
            if (!checkPrefix(x, item, l)) {
                continue;
            }
            path.add(item);
            dfs(x + 1, l);
            path.remove(path.size() - 1);
        }
    }
    
   
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        if (words == null || words.length ==0) {
            return ans;
        }
        initialPrefix(words);
        dfs(0, words[0].length());
        return ans;
    }
}