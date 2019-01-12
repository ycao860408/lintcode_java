public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        boolean first = true;
        while (slow != fast || first == true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            if (first) {
                first = false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}