public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int first = findtheFirst(A, target);
        int last = findtheLast(A, target);
        
        if (first == -1 || last == -1) {
            return 0;
        }
        
        return last - first + 1;
    }
    
    private int findtheFirst(int [] A, int target) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target <= A[mid]) {
                right = mid;
            } else {
                left = mid;
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
    
    private int findtheLast(int [] A, int target) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target < A[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
         if (A[right] == target) {
            return right;
        }
        
        if (A[left] == target) {
            return left;
        }
       
        return -1;
    }
}