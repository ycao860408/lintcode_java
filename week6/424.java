public class Solution {
    /**
     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
    public int evalRPN(String[] tokens) {
        // write your code here
        
        Stack<Integer> s = new Stack<Integer>();
        String operators = "+-*/";
        for (String token : tokens) {
            if (!operators.contains(token)) {
                s.push(Integer.valueOf(token));
            } else {
                int a = s.pop();
                int b = s.pop();
                if (token.equals("+")) {
                    s.push(a + b);
                }
                if (token.equals("-")) {
                    s.push(b - a);
                }
                if (token.equals("*")) {
                    s.push(a * b);
                }
                if (token.equals("/")) {
                    s.push(b / a);
                }
            }
        }
        return s.pop();
    }
}