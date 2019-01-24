public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = (A.length - 2) / 2; i >=0; i--) {
            shiftDown(A, i);
        }
    }
    
    private void shiftDown(int[] A, int k) {
        int n = A.length;
        while (k < n) {
            int left = k * 2 + 1;
            int right = k* 2 + 2;
            int minIdx = k;
            if (left < n && A[left] < A[minIdx]) {
                minIdx = left;
            }
            if (right < n && A[right] < A[minIdx]) {
                minIdx = right;
            }
            if (minIdx == k) {
                break;
            }
            int temp = A[minIdx];
            A[minIdx] = A[k];
            A[k] = temp;
            k = minIdx;
        }
    }
}