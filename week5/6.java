public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null) return B;
        if (B == null) return A;
        int lenA = A.length, lenB = B.length, i = 0, j = 0;
        int [] res = new int[lenA + lenB];
        int k = 0;
        while (i < lenA && j < lenB) {
            if (A[i]<= B[j]) {
                res[k++] = A[i++];
            } else {
                res[k++] = B[j++];
            }
        }
        while (i < lenA) {
            res[k++] = A[i++];
        }
        while (j < lenB) {
            res[k++] = B[j++];
        }
        return res;
    }
}

／／ 另一种简单的写法

public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null) return B;
        if (B == null) return A;
        int lenA = A.length, lenB = B.length, i = 0, j = 0;
        int [] res = new int[lenA + lenB];
        
        for (int k = 0; k < lenA + lenB; k++) {
            if (i < lenA && (j >= lenB|| A[i] <= B[j])) {
                res[k] = A[i++];
            } else {
                res[k] = B[j++];
            }
        }
        return res;
    }
}