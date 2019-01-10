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
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode target1 = null, target2 = null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode pre1 = null, pre2 = null;
        ListNode connect1 = null, connect2 = null;
        while ( head.next != null && (head.next.val != v1 && head.next.val != v2)) {
            head = head.next;
        }
        
        
        if (head.next == null) {
            return dummy.next;
        } 
        if (v1 == v2) {
            return dummy.next;
        }
        pre1 = head;
        target1 = head.next;
        
        head = target1;
        connect1 = target1.next;
        while ( head.next != null&&(head.next.val != v1 && head.next.val != v2)) {
            head = head.next;
        }
        if (head.next == null) {
            return dummy.next;
        } 
        pre2 = head;
        target2 = head.next;
        connect2 = target2.next;
        
        if (target1 == pre2) {
            pre1.next = target2;
            target2.next = target1;
            target1.next = connect2;
        }else if (connect1 == pre2) {
            pre1.next = target2;
            target2.next = connect1;
            pre2.next = target1;
            target1.next = connect2;
        } else {
            pre1.next = target2;
            target2.next = connect1;
            pre2.next = target1;
            target1.next = connect2;
        }
        return dummy.next;
    }
}