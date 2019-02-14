public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0,0, 1, -1};
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        // build Trie: insert
        TrieTree tree = new TrieTree(new TrieNode());
        for (String word : words) {
            tree.insert(word);
        }
        // iterate all positions in the matrix as start point. 
                // if the early step of the search does not in trie, then stop searching
        for (int i = 0; i < board.length; i++) {
            for (int j =0; j < board[0].length; j++) {
                search(board, i, j, tree.root, res);
            }
        }
        
        
        
        return res;
    }
    
    public void search(char[][] board, int x, int y, TrieNode cur, List<String> res) {
        if (!cur.children.containsKey(board[x][y])){
            return;
        }
        TrieNode child = cur.children.get(board[x][y]);
        if (child.word != null) {
            if (!res.contains(child.word)) {
                 res.add(child.word);
            }
        }
        char temp = board[x][y];
        board[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isValid(board, nx, ny)) {
                continue;
            }
            search(board, nx, ny, child, res);
        }
        board[x][y] = temp;
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return board[x][y] != '0';
    }
}

class TrieNode {
    String word; 
    Map<Character, TrieNode> children;
    public TrieNode() {
        children = new HashMap<>();
    }
}

class TrieTree{
    TrieNode root;
    TrieTree(TrieNode node) {
        root = node;
    }
    public void insert(String word) {
        TrieNode cur = root; 
        for (int i = 0; i < word.length();i++) {
            if (!cur.children.containsKey(word.charAt(i))) {
                cur.children.put(word.charAt(i), new TrieNode());
            }
            cur = cur.children.get(word.charAt(i));
        }
        cur.word = word;
    }
}