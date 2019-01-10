/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Pair {
    int time;
    int flag;
    
    Pair(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}

public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        Pair [] pairs = new Pair[2*airplanes.size()];
        int n = 0;
        
        for (Interval item: airplanes) {
            pairs[n++] = new Pair(item.start, 1);
            pairs[n++] = new Pair(item.end, -1);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isBigger(pairs[i], pairs[j])) {
                    Pair temp = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = temp;
                }
            }
        }
        
        int num = 0, res = Integer.MIN_VALUE;
        for (Pair item : pairs) {
            num += item.flag;
            res = Math.max(res, num);
        }
        
        return res;
    }
    
    private boolean isBigger(Pair a, Pair b) {
        return a.time == b.time ? a.flag > b.flag : a.time > b.time;
    }
}