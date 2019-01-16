public class Solution {
    /**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // write your code here
        if (A == null) {
            return 0;
        }
        int[] temp = new int[A.length];
        return helper(A, 0, A.length - 1, temp);
    }
    
    private int helper(int[] A, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int res = 0; 
        res += helper(A, left, mid, temp);
        res += helper(A, mid + 1, right, temp);
        int i = left, j = mid + 1;
        for (int k = 0; k < right - left + 1; k++) {
            if (i <= mid && (j > right || A[i] <= A[j])) {
                temp[k] = A[i++];
            } else {
                temp[k] = A[j++];
                if (i <= mid) {
                    res += (mid - i + 1);
                }
            }
        }
        for (int k = 0; k < right - left + 1; k++) {
            A[left + k] = temp[k];
        }
        return res;
    }
}