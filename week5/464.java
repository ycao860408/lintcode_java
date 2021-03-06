public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        helper(A, 0, A.length - 1);
    }
    // sort array from left to right;
    private void helper(int[] A, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        helper(A, left, mid);
        helper(A, mid + 1, right);
        int [] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        for (int k = 0; k < right - left + 1;k++) {
            if (i <= mid && (j > right || A[i] <= A[j])) {
                temp[k] = A[i++];
            } else {
                temp[k] = A[j++];
            }
        }
        for (int k = left; k <= right; k++) {
            A[k] = temp[k - left];
        }
    }
}

// optimize the space complexity: 

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        int [] temp = new int[A.length];
        helper(A, 0, A.length - 1,temp);
    }
    
    private void helper(int [] A, int left, int right,int[] temp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        helper(A, left, mid,temp);
        helper(A, mid + 1, right, temp);
        int i = left, j = mid + 1;

        for (int k = 0; k < right - left + 1; k++) {
            if (i <= mid && (j > right || A[i] <= A[j])) {
                temp[k] = A[i++];
            } else {
                temp[k] = A[j++];
            }
        }
        for (int k = 0; k < right - left + 1; k++) {
            A[k + left] = temp[k];
        }
    }
}

// quick sort 

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null) {
            return;
        }
        helper(A, 0, A.length - 1);
    }
    
    private void helper(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = A[left + (right - left) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (i <= j && A[i] < pivot) {
                i++;
            }
            
            while (i <= j && A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
        helper(A, left, j);
        helper(A, i, right);
    }
}

// randomly select the pivot

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null) {
            return;
        }
        helper(A, 0, A.length - 1);
    }
    
    private void helper(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = A[left + (int) (Math.random()*(right - left))];
        int i = left, j = right;
        while (i <= j) {
            while (i <= j && A[i] < pivot) {
                i++;
            }
            
            while (i <= j && A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
        helper(A, left, j);
        helper(A, i, right);
    }
}