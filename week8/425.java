public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    
    public List<String> letterCombinations(String digits) {
        // write your code here
        String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(0, "", digits, phone, res);
        return res;
    }
    
    private void dfs(int level, String cur, String digits, String[] phone, List<String> res) {
        if (level == digits.length()) {
            res.add(cur);
            return;
        }
        int d = digits.charAt(level) - '0';
        for (char c: phone[d].toCharArray()) {
            dfs(level + 1, cur + c, digits, phone, res);
        }
    }
}