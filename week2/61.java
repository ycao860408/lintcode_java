public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return new int[] {-1,-1};
        } 
        
        int [] res = new int[2];
        int low = lowerBound(A, target);
        int up = upBound(A, target);
        
        res[0] = low;
        res[1] = up;
        
        return res;
    }
    
    private int lowerBound(int[] A, int target) {
        int left = 0, right = A.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] >= target) {
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
    
    private int upBound(int[] A, int target) {
        int left = 0, right = A.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] > target) {
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