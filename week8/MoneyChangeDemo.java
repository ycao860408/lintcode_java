import java.util.*;

public class MoneyChangeDemo{
    static class Solution{
        public static List<List<Integer>> moneyChange(int money, List<Integer> change) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(change, 0, money, new ArrayList<>(), res);
            return res;
        }
        private static void  dfs(List<Integer> change, int index, int target, List<Integer> cur, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            
            if (target < 0) {
                return;
            }
            for (int i = index; i < change.size(); i++) {
                cur.add(change.get(i));
                dfs(change,i, target - change.get(i), cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> change = new ArrayList<>();
        change.add(1);
        change.add(2);
        change.add(5);
        //change.add(25);
        int money = 3;
        List<List<Integer>> changes = null;
        changes = Solution.moneyChange(money, change);
        System.out.println(changes.size());
        for (int i = 0;i < changes.size(); i++) {
            System.out.println("The " + (i + 1) + "th way: ");
            for (int j = 0; j < changes.get(i).size(); j++) {
                System.out.print(changes.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
