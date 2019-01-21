public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] strChar = s.toCharArray();
        Stack<Character> sstack = new Stack<>();
        for (char item : strChar) {
            if (item == '(' || item == '[' || item == '{') {
                sstack.push(item);
            } 
            if (item == ')') {
                if (sstack.isEmpty() || sstack.pop() != '(') {
                    return false;
                }
            }
            if (item == '}') {
                if (sstack.isEmpty() || sstack.pop() != '{') {
                    return false;
                }
            }
            if (item == ']') {
                if (sstack.isEmpty() || sstack.pop() != '[') {
                    return false;
                }
            }
        }
        return sstack.isEmpty() ? true : false;
    }
}