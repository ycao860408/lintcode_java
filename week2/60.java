public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int left = 0, right = A.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if ( A[left] == target) {
            return left;
        }
        
        if (A[right] == target) {
            return right;
        }
        
        if (A[right] < target) {
            return right + 1;
        } else if (A[left] < target) {
            return right;
        } else {
            return left - 1 < 0 ? 0 : left - 1;
        }
        
    }
}