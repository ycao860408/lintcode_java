public class Solution {
        
    class TrieNode{
        TrieNode[] sons = new TrieNode[26];
        String word;
        int idx;
    }
    
    TrieNode root;
    
    void insert(String str, int idx){
        TrieNode d = root;
        for (char c : str.toCharArray()){
            if (d.sons[c - 'a'] == null){
                d.sons[c - 'a'] = new TrieNode();
            }
            d = d.sons[c - 'a'];
        }
        d.word = str;
        d.idx = idx;
    }

    boolean checkPalin(char[] A, int lo, int hi){
        if (reverse && lo > hi){
            return false;
        }
        while (lo < hi){
            if (A[lo++] != A[hi--]){
                return false;
            }
        }
        return true;
    }
    
    List<List<Integer>> find(String str, int idx){
        List<List<Integer>> ans = new ArrayList<>();
        char[] A = str.toCharArray();
        TrieNode d = root;
        if (d.word != null && d.idx != idx && checkPalin(A, 0, A.length - 1)){
            // deal with empty string as input
            ans.add(reverse ? Arrays.asList(idx, d.idx) : Arrays.asList(d.idx, idx));
        }
        for (int i = A.length - 1; i >= 0; i--){
            d = d.sons[A[i] - 'a'];
            if (d == null){
                break;
            }
            if (d.word != null && d.idx != idx && checkPalin(A, 0, i - 1)){
                // found a word, how check whether the remainder of str is palin
                ans.add(reverse ? Arrays.asList(idx, d.idx) : Arrays.asList(d.idx, idx));
            }
        }
        return ans;
    }
    
    /**
     * @param words: a list of unique words
     * @return: all pairs of distinct indices
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        // Write your code here
        List<List<Integer>> ans = helper(words);
        for (int i = 0; i < words.length; i++){
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        reverse = true;

        ans.addAll(helper(words));

        return ans;
    }
    
    boolean reverse = false;
    
    List<List<Integer>> helper(String[] words){
        List<List<Integer>> ans = new ArrayList<>();
        root = new TrieNode();
        for (int i = 0; i < words.length; i++){
            insert(words[i], i);
        }
        for (int i = 0; i < words.length; i++){
            ans.addAll(find(words[i], i));
        }
        return ans;
    }
}