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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || k <= 0) {
            return head;
        }
        
        int length = linkLength(head);
        int netmove = k % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if ( netmove != 0) {
            
            ListNode cur = dummy;
            ListNode newStart = null, newEnd = null;
            for (int i = 1; i <= length; i++) {
                cur = cur.next;
                if (i == length - netmove) {
                    newStart = cur.next;
                    newEnd = cur;
                }
            }
            ListNode end = cur;
            end.next = dummy.next;
            dummy.next = newStart;
            newEnd.next = null;
        }
        return dummy.next;
    }
    
    private int linkLength(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum++;
            head = head.next;
        }
        return sum;
    }
    
    
}