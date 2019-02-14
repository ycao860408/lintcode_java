public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        
        int m = coins.length; 
        int[] states = new int[amount + 1];
        states[0] = 0; 
        for (int i = 1; i <= amount; i++) {
            states[i] = -1;
            for (int j = 0; j < m; j++) {
                if (i >= coins[j] && states[i - coins[j]] != -1) {
                    if (states[i] == -1 || states[i] > states[i - coins[j]] + 1) {
                        states[i] = states[i - coins[j]] + 1;
                    }
                }
            }
        }
        return states[amount];
    }
}