public class MinStack {
    Stack<Integer> ss;
    Stack<Integer> ms;
    public MinStack() {
        // do intialization if necessary
        ss = new Stack<Integer>();
        ms = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        ss.push(number);
        if (ms.isEmpty()) {
            ms.push(number);
        } else {
            ms.push(Math.min(ms.peek(), number));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        ms.pop();
        return ss.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return ms.peek();
    }
}