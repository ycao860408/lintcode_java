public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private List<Integer> stack = new ArrayList<>();
    
    
    public void push(int x) {
        // write your code here
        stack.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        if (!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return -1;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return stack.size() == 0;
    }
}