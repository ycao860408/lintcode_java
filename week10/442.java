public class Trie {
    private TrieNode root;
    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode cur = root;
        Map<Character ,TrieNode> curChildren = cur.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char curChar = wordArray[i];
            if (curChildren.containsKey(curChar)) {
                cur = curChildren.get(curChar);
            } else {
                TrieNode newNode = new TrieNode(curChar);
                curChildren.put(curChar, newNode);
                cur = curChildren.get(curChar);
            }
            curChildren = cur.children;
        }
        cur.hasWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public TrieNode searchWordNodePosition(String word) {
        TrieNode cur = root;
        Map<Character, TrieNode> curChildren = cur.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char curChar = wordArray[i];
            if (curChildren.containsKey(curChar)) {
                cur = curChildren.get(curChar);
                curChildren = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }
    
    public boolean search(String word) {
        // write your code here
        TrieNode wordNode = searchWordNodePosition(word);
        if (wordNode == null) {
            return false;
        } else if (wordNode.hasWord) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode wordNode = searchWordNodePosition(prefix);
        if (wordNode == null) {
            return false;
        }
        return true;
    }
}

class TrieNode{
    char c;
    boolean hasWord;
    Map<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {};
    public TrieNode(char c) {
        this.c = c;
        hasWord = false;
    }
}