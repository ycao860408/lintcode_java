public class WordDictionary {
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    private TrieNode root; 
    
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        // write your code here
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.hasWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return find(word, 0, root);
    }
    private boolean find(String word, int index, TrieNode cur) {
        if (index == word.length()) {
            return cur.hasWord;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (find(word, index + 1, cur.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            boolean isFind  = cur.children[ch - 'a'] != null;
            if (isFind) {
                return find(word, index + 1, cur.children[ch - 'a']);
            } else {
                return false;
            }
        }
    }
}

class TrieNode {
    public TrieNode[] children;
    boolean hasWord;
    TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < children.length; i++) {
            children[i] = null;
        }
        hasWord = false;
    }
}