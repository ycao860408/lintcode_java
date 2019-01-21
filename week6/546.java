class ListNode {
    int val;
    ListNode next, pre;
    ListNode(int val) {
        this.val = val;
        pre = next = null;
    }
}
interface InterfaceQueue {
    void push(int val);

    // define an interface for pop method
    /* write your code here */
    int pop();
    // define an interface for top method
    /* write your code here */
    int top();
}

public class MyQueue implements InterfaceQueue{
    public ListNode first, last; 
    public MyQueue() {
        // do intialization if necessary
        first = last = null;
    }

    // implement the push method
    /* write your code here */

    @Override
    public int pop() {
        // write your code here
        if (first == null) {
            return -1;
        }
        int temp = first.val;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.pre = null;
        }
        return temp;
        
    }

    @Override
    public int top() {
        // write your code here
        if (first == null) {
            return -1;
        }
        return first.val;
    }
    
    @Override
    public void push(int val) {
        if (last == null) {
            last = new ListNode(val);
            first = last;
        } else {
            ListNode node = new ListNode(val);
            last.next = node;
            node.pre = last;
            last = last.next;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue queue = new MyQueue();
 * queue.push(123);
 * queue.top(); will return 123;
 * queue.pop(); will return 123 and pop the first element in the queue
 */