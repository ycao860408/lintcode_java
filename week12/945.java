class Point {
    char c;
    int total;
    public Point(char c, int total) {
        this.c = c;
        this.total = total;
    }
}

class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        if (b.total != a.total) {
            return b.total - a.total;
        }
        return a.c - b.c;  
    } 
}

public class Solution {
    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n: the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {
        // write your code here
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        
        int curNum = 0;
        List<Character> temp = new ArrayList<>();
        PriorityQueue<Point> av = new PriorityQueue<>(new PointComparator());
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tasks.length; i++) {
            map.putIfAbsent(tasks[i], 0);
            map.put(tasks[i], map.get(tasks[i])+1);
        }
        
        for ( char item : map.keySet()) {
            av.offer(new Point(item, map.get(item)));
        }
        
        while (curNum != tasks.length) {
            if (av.isEmpty()) {
                temp.add('0');
            } else {
                Point cur = av.poll();
                temp.add(cur.c);
                curNum++;
                map.put(cur.c, cur.total-1);
            }
            int curlen = temp.size();
            if (curlen > n) {
                char ok = temp.get(curlen - n - 1);
                if (ok != '0' && map.get(ok) != 0) {
                    av.offer(new Point(ok, map.get(ok)));
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        return temp.size();
    }
}