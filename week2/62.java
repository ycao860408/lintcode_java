public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int lval = A[0], rval = A[A.length - 1];
        int left = 0, right = A.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] == target) {
                return mid;
            }
            
            if (A[mid] >= lval) {
                if (lval <= target && target < A[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (target <= rval && A[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (A[left] == target) {
            return left;
        }
        if (A[right] == target) {
            return right;
        }
        return -1;
    }
}