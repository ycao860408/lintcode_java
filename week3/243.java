public class Solution {
    /*
     * @param k: An integer
     * @return: all amicable pairs
     */
    public List<List<Integer>> amicablePair(int k) {
        // write your code here
        Set<List<Integer>> res  = new HashSet<>();
        for (int i = 1; i <=k; i++) {
            List<Integer> item = new ArrayList<>();
            int sum1 = sumDivdor(i);
            if (sum1 > k || sum1 == i) {
                continue;
            } 
            int sum2 = sumDivdor(sum1);
            if (sum2 != i) {
                continue;
            }
            item.add(Math.min(i, sum1));
            item.add(Math.max(i,sum1));
            res.add(item);
        }
        return new ArrayList<List<Integer>>(res);
    }
    
    private int sumDivdor(int num) {
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
           if (num % i == 0) {
               sum += i;
               if ( i * i != num && i * num != num) {
                   sum += (num / i);
               }
           }
        }
        return sum;
    }
}