public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    
    public void push(int x) {
        // write your code here
        q1.offer(x);
    }
    private void move() {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
    }
    
    private void swap() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        move();
        q1.poll();
        swap();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        move();
        int res = q1.poll();
        swap();
        q1.offer(res);
        return res;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return q1.isEmpty();
    }
}