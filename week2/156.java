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
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
                return  a.start - b.start;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
       }
        
        Collections.sort(intervals, new IntervalComparator());
        
        List<Interval> result = new ArrayList<>();
        
        Interval pre = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
           Interval curt = intervals.get(i);
            if (curt.start <= pre.end) {
                pre.end = Math.max(pre.end, curt.end);
            } else {
                result.add(pre);
                pre = curt;
            }
        }
        
        result.add(pre);
        return result;
        
    }
    
    
}