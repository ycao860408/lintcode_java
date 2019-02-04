public class Solution {
    /**
     * @param num: a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    String num;
    int target; 
    List<String> ans = new ArrayList<>();
    
    void dfs(int level, String cur, long R, long A) {
        if (level == num.length()) {
            if (R == target) {
                ans.add(cur);
            }
            return;
        }
        
        // next Number
        // num 12 + 3 * 1 * 3  213213
        for (int i = level; i < num.length(); i++) {
            long P = Long.parseLong(num.substring(level, i + 1));
            // convert num[level, ... i] to number
            if (level == 0) {
                dfs(i + 1, cur + P, P, P);
            } else {
                dfs(i + 1, cur + "+" + P, R+ P, P);
                dfs(i + 1, cur + "-" + P, R - P, -P);
                dfs(i + 1, cur + "*" + P, R - A + A*P, A*P);
            }
            if (P == 0){
                break;
            }
        }
    }
    
    
    public List<String> addOperators(String nums, int targets) {
        // write your code here
        num = nums;
        target = targets;
        // level
        // cur 
        // R 
        // A 
        dfs(0,"",0,0);
        return ans;
        
    }
}