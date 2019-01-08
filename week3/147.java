public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        if (n == 0) {
            return null;
        }
        int lower = (int) Math.pow(10, n - 1);
        int upper = (int) Math.pow(10, n);
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
        }
        for (int i = lower; i < upper; i++) {
            if (isNas(i, n)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean isNas(int num, int n) {
        int sum = 0;
        int temp = num;
        while (temp != 0) {
            sum += (int) Math.pow(temp % 10, n);
            temp /= 10;
        }
        return sum == num ? true : false;
    }
}