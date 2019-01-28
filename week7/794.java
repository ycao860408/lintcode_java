public class Solution {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        String source = matrixToString(init_state);
        String target = matrixToString(final_state);
        
        Queue<String> que = new LinkedList<>();
        Set<String> set = new HashSet<>();
        que.offer(source);
        set.add(source);
        int res = 0;
        
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String cur = que.poll();
                if (cur.equals(target)) {
                    return res;
                }
                for (String next : getNext(cur)) {
                    if(!set.contains(next)) {
                        que.offer(next);
                        set.add(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }
    
    private String matrixToString(int[][] state) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i ++) {
            for (int j =0; j < 3; j++) {
                sb.append(state[i][j]);
            }
        }
        return sb.toString();
    }
    
    private List<String> getNext(String cur) {
        List<String> candidates = new ArrayList<>();
        int zeroIndex = cur.indexOf('0');
        int x = zeroIndex / 3;
        int y= zeroIndex % 3;
        int [] dx = {1, -1, 0, 0};
        int [] dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                continue;
            }
            char[] scr = cur.toCharArray();
            scr[zeroIndex] = scr[nx * 3 + ny];
            scr[nx * 3 + ny] = '0';
            candidates.add(new String(scr));
        }
        return candidates;
    }
}