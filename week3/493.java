class ListNode {
    int x;
    ListNode next, pre;
    ListNode(int x) {
        this.x = x;
        next = null;
        pre = null;
    }
}
public class Dequeue {
    ListNode head,end;
    public Dequeue() {
        // do intialization if necessary
        head = end = null;
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_front(int item) {
        // write your code here
        if (head == null) {
            head = end = new ListNode(item);
        } else {
            ListNode newNode = new ListNode(item);
            newNode.next = head;
            head.pre = newNode;
            if (end == head) {
                end = head;
            }
            head = newNode;
        }
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_back(int item) {
        // write your code here
        if (head == null) {
            head = end = new ListNode(item);
        } else {
            ListNode newNode = new ListNode(item);
            end.next = newNode;
            newNode.pre = end;
            end = newNode;
        }
    }

    /*
     * @return: An integer
     */
    public int pop_front() {
        // write your code here
        int res = Integer.MIN_VALUE; 
        
        if (head != null){
            res = head.x;
            if (head == end) {
                head = end = null;
            } else {
                head = head.next;
                head.pre = null;
            }
        }
        return res;
    }

    /*
     * @return: An integer
     */
    public int pop_back() {
        // write your code here
        int res = Integer.MIN_VALUE;
        if (head != null) {
            res = end.x;
            if (end == head) {
                head = end = null;
            } else {
                end = end.pre;
                end.next = null;
            }
        }
        return res;
    }
}