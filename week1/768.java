public class Solution {
    /**
     * @param n: a Integer
     * @return: the first n-line Yang Hui's triangle
     */
    public List<List<Integer>> calcYangHuisTriangle(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<> ();
        
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            if (i >= 1) {
                temp.add(1);
            }
            res.add(temp);
        }
        return res;
    }
}