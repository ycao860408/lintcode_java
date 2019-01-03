public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int left = 1, right = A.length - 2;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] < A[mid - 1]) {
                right = mid;
            } else if (A[mid] < A[mid + 1]) {
                left = mid;
            } else {
                return mid;
            }
        }
        
        if (A[left] > A[left - 1] && A[left] > A[left + 1]) {
            return left;
        }
        if (A[right] > A[right- 1] && A[right] > A[right + 1]) {
            return right;
        }
        
        return -1;
        
    }
}