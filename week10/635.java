public class Solution {
    /*
     * @param board: a list of lists of character
     * @param words: a list of string
     * @return: an integer
     */
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode('0');
        }
        
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode cur = root;
            TrieNode[] curChild = cur.children;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (curChild[curChar - 'a'] == null) {
                    curChild[curChar - 'a'] = new TrieNode(curChar);
                }
                cur = curChild[curChar - 'a'];
                curChild = cur.children;
            }
            cur.isWord = true;
        }
    }
    
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;
        TrieNode(char v) {
            this.val = v;
            isWord = false;
            children = new TrieNode[26];
        }
    }
    public int boggleGame(char[][] board, String[] words) {
        // write your code here
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length, n = board[0].length;
        List<String> result = new ArrayList<>();
        boolean visited[][] = new boolean[m][n];
        List<String> path = new ArrayList<>();
        findWords(result, board, visited, path, 0, 0, trie.root);
        return result.size();
    }
    
    public void findWords(List<String> result, char[][] board, boolean[][] visited, List<String> words, int x, int y, TrieNode root) {
        int m = board.length, n = board[0].length; 
        for (int i = x; i < m; i++) {
            for (int j = y; j < n; j++) {
                List<List<Integer>> nextWordIndex = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                getNextWords(nextWordIndex, board, visited, path, i, j, root);
                for (List<Integer> indices : nextWordIndex) {
                    String word = "";
                    for (int index : indices) {
                        int row = index  / n;
                        int col = index % n;
                        visited[row][col] = true;
                        word+= board[row][col];
                    }
                    
                    words.add(word);
                    if (words.size() > result.size()) {
                        result.clear();
                        result.addAll(words);
                    }
                    findWords(result, board, visited, words, i, j, root);
                    
                    for (int index : indices) {
                        int row = index  / n;
                        int col = index % n;
                        visited[row][col] = false;
                    }
                    words.remove(words.size() - 1);
                }
            }
            y = 0;
        }
    }
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};
    
    private void getNextWords(List<List<Integer>> words, char[][] board, boolean[][] visited, List<Integer> path, int i, int j, TrieNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true ||root.children[board[i][j] - 'a'] == null) {
            return;
        }
        
        root = root.children[board[i][j] - 'a']; 
        if (root.isWord) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(i * board[0].length + j);
            words.add(newPath);
            return;
        }
        visited[i][j] = true;
        path.add(i * board[0].length + j);
        for (int k = 0; k < 4; k++) {
            getNextWords(words, board, visited, path, i + dx[k], j + dy[k], root);
        }
        path.remove(path.size() - 1);
        visited[i][j] = false;
    }
}