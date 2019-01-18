public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] A, int k) {
        // write your code here
        if (A == null) {
            return 0;
        }
        
        int i = 0, j = A.length - 1;
        while (i <= j) {
            while (i <= j && A[i] < k) {
                i++;
            }
            while (i <= j && A[j] >= k) {
                j--;
            }
            
            if (i <= j) {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
        return i;
    }
}