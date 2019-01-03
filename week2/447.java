public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int k = 1; 
        while (reader.get(k) < target) {
            k*= 2;
        }
        
        int left = k / 2, right = k;
        
        while ( left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (reader.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
       
        if (reader.get(left) == target) {
            return left;
        }
        if (reader.get(right) == target) {
            return right;
        }
        
        
        return -1;
    }
}