public class Solution {
    /*
    * @param k: An integer
    */
    int size = 0, n = 0; 
    int A[] = null;
    
    public Solution(int k) {
        // do intialization if necessary
        size = k;
        A = new int[k + 1];
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (n < size) {
            offer(num);
        } else {
            if (num > A[0]) {
                poll();
                offer(num);
            }
        }
    }

    private void offer(int num) {
        A[n] = num;
        int k = n;
        n++;
        while (k > 0) {
            int par = (k - 1) / 2;
            if (A[par] >  A[k]) {
                int temp = A[par];
                A[par] = A[k];
                A[k] = temp;
            }
            k = par;
        }
    }
    
    private void poll() {
        A[0] = A[n - 1];
        n--;
        int k = 0;
        while (k < n) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
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
    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(A[i]);
        }
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
}