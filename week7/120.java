public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)){
            return 1;
        }
        
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        
        Queue<String> que = new LinkedList<>();
        Set<String> set = new HashSet<>();
        dict.add(start);
        dict.add(end);
        
        que.offer(start);
        set.add(start);
        int res = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String cur = que.poll();
                if (cur.equals(end)) {
                    return res;
                }
                for (String nextWord : getNextWords(cur, dict)) {
                    if (!set.contains(nextWord)) {
                        set.add(nextWord);
                        que.offer(nextWord);
                    }
                }
            }
            res++;
        }
        return 0;
    }
    
    private List<String> getNextWords(String cur, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (cur.charAt(i) == c) {
                    continue;
                }
                char[] csr = cur.toCharArray();
                csr[i] = c;
                String next = new String(csr);
                if (dict.contains(next)) {
                    nextWords.add(next);
                }
            }
        }
        return nextWords;
    }
}