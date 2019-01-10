public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0 || k <=0) {
            return 0;
        }
        
        int left = 0, right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isleK(pages, mid, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if(isleK(pages, left, k)) {
            return left;
        }
        return right;
    }
    
    private boolean isleK(int [] pages, int limit, int k) {
        int num = 0; 
        int left = 0;
        
        for (int item : pages) {
            if (item > limit) {
                return false;
            }
            
            if (item > left) {
                num++;
                left = limit;
            }
            left -= item;
        }
        return num <= k;
    }
}