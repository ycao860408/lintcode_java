public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        // write your code here
        if (coins == null) {
            return -1;
        }
        dfs(coins, 0, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private void dfs(int[] coins, int index, int amount, int num) {
        if (num > ans) {
            return;
        }
        if (index == coins.length) {
            if (amount == 0) {
                ans = Math.min(ans, num);
            }
            return;
        }
        
        if (coins[index] == 0) {
            dfs(coins, index + 1, amount, num);
            return;
        }
        for (int cnt = 0; coins[index] * cnt <= amount; cnt++) {
            dfs(coins, index + 1, amount - cnt * coins[index], num + cnt);
        }
    }
}