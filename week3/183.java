public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0 || k == 0) {
            return 0;
        }
        
        int potentialMax = Integer.MIN_VALUE;
        
        for (int item : L) {
            potentialMax = Math.max(potentialMax, item);
        }
        int left = 1, right = potentialMax; 
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (numPiece(L, mid) >=k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (numPiece(L,right) >= k) {
            return right;
        } 
        
        if (numPiece(L, left) >= k) {
            return left;
        }
        
        return 0;
    }
    
    private int numPiece(int[] L, int len) {
        int sum = 0; 
        for (int item : L) {
            sum += (item / len);
        }
        return sum;
    }
}