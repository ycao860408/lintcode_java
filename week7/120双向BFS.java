public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        Queue<String> queA = new LinkedList<>();
        Set<String> setA = new HashSet<>();
        Queue<String> queB = new LinkedList<>();
        Set<String> setB = new HashSet<>();
        queA.offer(start);
        setA.add(start);
        queB.offer(end);
        setB.add(end);
        
        Queue<String> curQue = null;
        Set<String> setCur = null , setOp = null;
        int res = 1;
        
        while (!queA.isEmpty() && !queB.isEmpty()) {
            int m = queA.size();
            int n = queB.size();
            if (m <= n) {
                curQue = queA;
                setCur = setA;
                setOp = setB;
            } else {
                curQue = queB;
                setCur = setB;
                setOp = setA;
            }
            int size = Math.min(m,n);
            res++;
            for (int i = 0; i < size; i++) {
                String cur = curQue.poll();
                for (String nei : getNextWords(cur, dict)) {
                    if (setOp.contains(nei)) {
                        return res;
                    }
                    if (!setCur.contains(nei)) {
                        curQue.offer(nei);
                        setCur.add(nei);
                    }
                }
            }
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