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

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        
        List<Interval> result = new ArrayList<>();
        int iloc = 0;
        
        for (Interval item: intervals) {
            if (item.end < newInterval.start) {
                result.add(item);
                iloc++;
            } else if (newInterval.end < item.start) {
                result.add(item);
            } else {
                newInterval.start = Math.min(newInterval.start, item.start);
                newInterval.end = Math.max(newInterval.end, item.end);
            }
        }
        
        result.add(iloc, newInterval);
        
        return result;
    }
}