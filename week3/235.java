public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                num /= i;
                res.add(i);
            }
        }
        
        if (num != 1) {
            res.add(num);
        }
        return res;
    }
}