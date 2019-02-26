class State {
    int g, f;
    State(int g_in, int f) {
        this.f = f;
        g = g_in;
    }
}
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
        if (!check(source, target)) {
            return -1;
        }
        Map <String, State> open = new HashMap<>();
        Set <String> close = new HashSet<>();
        open.put(source, new State(0, getH(source, target)));
        while (open.size() != 0) {
            String cur = findMin(open);
            if (cur.equals(target)) {
                return open.get(cur).g;
            }
            close.add(cur);
            for (String next : getNext(cur)) {
                if (!close.contains(next)) {
                    if (!open.containsKey(next) || open.get(next).g > open.get(cur).g + 1) {
                        open.put(next, new State(open.get(cur).g + 1, open.get(cur).g + 1 + getH(next, target)));
                    }
                }
            }
            open.remove(cur);
        }
        return -1;
    }
    
    private String findMin(Map<String, State> open) {
        String ret = "";
        int minF = Integer.MAX_VALUE;
        for (String key : open.keySet()) {
            if (open.get(key).f < minF) {
                minF = open.get(key).f;
                ret = key;
            }
        }
        return ret;
    }
    
    private int getH(String c, String t) {
        int ret = 0; 
        for (int i = 0; i < 9; i++) {
            if (c.charAt(i) != t.charAt(i) && t.charAt(i) != '0') {
                ret++;
            }
        }
        return ret;
    }
    
    
    private String matrixToString(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }
    
    private boolean check(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int r1 = 0, r2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                if (s[i] != '0' && s[j] != '0' && s[j] > s[i]) {
                    r1++;
                }
                if (t[i] != '0' && t[j] != '0' && t[j] > t[i]) {
                    r2++;
                }
            }
        }
        return r1 % 2 == r2 % 2;
    }
    
    
    private List<String> getNext(String cur) {
        List<String> ret = new ArrayList<>();
        int zeroIndex = cur.indexOf('0');
        int x = zeroIndex / 3; 
        int y = zeroIndex % 3;
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                int nextIndex = nx * 3 + ny;
                char[] tstr = cur.toCharArray();
                tstr[zeroIndex] = tstr[nextIndex];
                tstr[nextIndex] = '0';
                ret.add(new String(tstr)); 
            }
        }
        return ret;
    }
}

// 曼哈顿距离 
class State {
    int g, f;
    State(int g_in, int f) {
        this.f = f;
        g = g_in;
    }
}
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
        if (!check(source, target)) {
            return -1;
        }
        Map <String, State> open = new HashMap<>();
        Set <String> close = new HashSet<>();
        open.put(source, new State(0, getH(source, target)));
        while (open.size() != 0) {
            String cur = findMin(open);
            if (cur.equals(target)) {
                return open.get(cur).g;
            }
            close.add(cur);
            for (String next : getNext(cur)) {
                if (!close.contains(next)) {
                    if (!open.containsKey(next) || open.get(next).g > open.get(cur).g + 1) {
                        open.put(next, new State(open.get(cur).g + 1, open.get(cur).g + 1 + getH(next, target)));
                    }
                }
            }
            open.remove(cur);
        }
        return -1;
    }
    
    private String findMin(Map<String, State> open) {
        String ret = "";
        int minF = Integer.MAX_VALUE;
        for (String key : open.keySet()) {
            if (open.get(key).f < minF) {
                minF = open.get(key).f;
                ret = key;
            }
        }
        return ret;
    }
    
    private int getH(String c, String t) {
        int ret = 0; 
        for (int i = 0; i < 9; i++) {
           if (t.charAt(i) != '0') {
               int idx = c.indexOf(t.charAt(i));
               int x = idx / 3;
               int y = idx % 3;
               int tx = i / 3;
               int ty = i % 3;
               ret += Math.abs(x - tx) + Math.abs(y - ty);
           }
        }
        return ret;
    }
    
    
    private String matrixToString(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }
    
    private boolean check(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int r1 = 0, r2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                if (s[i] != '0' && s[j] != '0' && s[j] > s[i]) {
                    r1++;
                }
                if (t[i] != '0' && t[j] != '0' && t[j] > t[i]) {
                    r2++;
                }
            }
        }
        return r1 % 2 == r2 % 2;
    }
    
    
    private List<String> getNext(String cur) {
        List<String> ret = new ArrayList<>();
        int zeroIndex = cur.indexOf('0');
        int x = zeroIndex / 3; 
        int y = zeroIndex % 3;
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                int nextIndex = nx * 3 + ny;
                char[] tstr = cur.toCharArray();
                tstr[zeroIndex] = tstr[nextIndex];
                tstr[nextIndex] = '0';
                ret.add(new String(tstr)); 
            }
        }
        return ret;
    }
}

// id A * 

class State {
    int g, f;
    State(int g_in, int f) {
        this.f = f;
        g = g_in;
    }
}
public class Solution {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    boolean found = false;
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        String source = matrixToString(init_state);
        String target = matrixToString(final_state);
        if (!check(source, target)) {
            return -1;
        }
        int limit = 0; 
        while (!found) {
            limit++;
            dfs(0, limit, source, target);
        }
        return limit;
    }
    
    private void dfs(int g, int limit, String str, String target) {
        if (g  > limit) {
            return;
        }
        if (found) {
            return;
        }
        int h = getH(str, target);
        if (g + h > limit) {
            return;
        }
        if (h == 0) {
            found = true;
            return;
        }
        for (String next : getNext(str)) {
            dfs(g + 1, limit, next, target);
        }
    }
    
    private String findMin(Map<String, State> open) {
        String ret = "";
        int minF = Integer.MAX_VALUE;
        for (String key : open.keySet()) {
            if (open.get(key).f < minF) {
                minF = open.get(key).f;
                ret = key;
            }
        }
        return ret;
    }
    
    private int getH(String c, String t) {
        int ret = 0; 
        for (int i = 0; i < 9; i++) {
           if (t.charAt(i) != '0') {
               int idx = c.indexOf(t.charAt(i));
               int x = idx / 3;
               int y = idx % 3;
               int tx = i / 3;
               int ty = i % 3;
               ret += Math.abs(x - tx) + Math.abs(y - ty);
           }
        }
        return ret;
    }
    
    
    private String matrixToString(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }
    
    private boolean check(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int r1 = 0, r2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                if (s[i] != '0' && s[j] != '0' && s[j] > s[i]) {
                    r1++;
                }
                if (t[i] != '0' && t[j] != '0' && t[j] > t[i]) {
                    r2++;
                }
            }
        }
        return r1 % 2 == r2 % 2;
    }
    
    
    private List<String> getNext(String cur) {
        List<String> ret = new ArrayList<>();
        int zeroIndex = cur.indexOf('0');
        int x = zeroIndex / 3; 
        int y = zeroIndex % 3;
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                int nextIndex = nx * 3 + ny;
                char[] tstr = cur.toCharArray();
                tstr[zeroIndex] = tstr[nextIndex];
                tstr[nextIndex] = '0';
                ret.add(new String(tstr)); 
            }
        }
        return ret;
    }
}