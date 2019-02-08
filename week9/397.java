public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A.length == 0) {
            return 0;
        }
        
        int icr = 1, dcr = 1, longest = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                icr++;
                dcr = 1;
            } else if (A[i] < A[i - 1]) {
                dcr++;
                icr = 1;
            } else {
                icr = 1 ;
                dcr = 1 ;
            }
            longest = Math.max(longest, Math.max(icr, dcr));
        }
        return longest;
    }
}