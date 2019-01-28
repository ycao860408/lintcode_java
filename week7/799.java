public class Solution {
    /**
     * @param deadends: the list of deadends
     * @param target: the value of the wheels that will unlock the lock
     * @return: the minimum total number of turns 
     */
    public int openLock(String[] deadends, String target) {
        // Write your code here
        String start = "0000";
        Queue<String> que = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> deadSet = new HashSet<>();
        for (String deadlock : deadends) {
            if (deadlock.equals(start)) {
                return -1;
            }
            deadSet.add(deadlock);
        }
        int res = 0;
        que.offer(start);
        set.add(start);
        while(! que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String cur = que.poll();
                if (cur.equals(target)) {
                    return res;
                }
                for (String next : nextNums(cur, deadSet)) {
                    if (!set.contains(next)) {
                        que.offer(next);
                        set.add(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }
    
    private List<String> nextNums(String cur, Set<String> deadSet) {
        List<String> nextCandidate = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            char[] scr = cur.toCharArray();
            char origin = scr[i];
            scr[i] =(char) ((origin - '0' + 1) % 10 + '0'); 
            String next = new String(scr);
            if (!deadSet.contains(next)) {
                nextCandidate.add(next);
            }
            
            scr[i] =(char)((origin - '0' - 1 + 10) % 10 + '0'); 
            next = new String(scr);
            if (!deadSet.contains(next)) {
                nextCandidate.add(next);
            }
        }
        return nextCandidate;
    }
}