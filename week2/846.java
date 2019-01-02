public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public int[][] multiSort(int[][] array) {
        // Write your code here
        int length = array.length;
        
        while (true) {
            boolean change = false;
            for (int i = 0; i < length - 1; i++) {
                if (changeOrNot(array[i],array[i + 1])) {
                    int [] temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
        return array;
        
    }
    private boolean changeOrNot(int[] st1, int[] st2) {
        if (st1[1] > st2[1])
            return false;
        else if (st1[1] == st2[1] && st1[0] < st2[0]) 
            return false;
        else 
            return true;
    }
}