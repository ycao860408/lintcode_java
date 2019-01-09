/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return false;
        }
        ListNode fast, slow;
        fast = slow = head;
        boolean first = true;
        while (fast != null && slow != null) {
            if (fast == slow && first) {
                first = false;
            } else if (fast == slow) {
                return true;
            }
            if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return false;
    }
}