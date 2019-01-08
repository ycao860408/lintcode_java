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
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode npre = null, ncur = head, nnext = head.next;
        
        while (nnext != null) {
            ncur.next = npre;
            npre = ncur;
            ncur = nnext;
            nnext = nnext.next;
        }
        ncur.next = npre;
        return ncur;
    }
}