/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Queue<Integer>> temp = new HashMap<>();
        Map<Integer, Double> res = new HashMap<>();
        if (results == null || results.length == 0) {
            return res;
        }
        
        for (Record item : results) {
            if (!temp.containsKey(item.id)) {
                temp.put(item.id,new PriorityQueue<Integer>(5));
                temp.get(item.id).offer(item.score);
                res.put(item.id, 0.0 + item.score);
                
            } else {
                if (temp.get(item.id).size() < 5) {
                    temp.get(item.id).offer(item.score);
                    res.put(item.id, res.get(item.id) + item.score );
                }
                else if (item.score > temp.get(item.id).peek()) {
                    double drop = temp.get(item.id).poll();
                    temp.get(item.id).offer(item.score);
                    res.put(item.id, res.get(item.id) - drop + item.score);
                }
            }
        }
        for (Integer key : res.keySet()) {
            res.put(key, res.get(key)/ 5);
        }
        
        return res;
        
    }
}