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
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        
        
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while(cur.next != null && cur.next.val <= val) {
            cur = cur.next;
        }
        
        ListNode temp = cur.next;
        cur.next = new ListNode(val);
        cur.next.next = temp;
        
        return dummy.next;
    }
}