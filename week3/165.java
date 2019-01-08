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
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummyres = new ListNode(Integer.MIN_VALUE);
        ListNode cur1 = l1, cur2 = l2, cur3 = dummyres;
        while (cur1 != null || cur2 != null) {
            int newVal = 0;
            if (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    newVal = cur1.val;
                    cur1 = cur1.next;
                } else {
                    newVal = cur2.val;
                    cur2 = cur2.next;
                }
            } else {
                if (cur1 != null) {
                    newVal = cur1.val;
                    cur1 = cur1.next;
                }
                if (cur2 != null) {
                    newVal = cur2.val;
                    cur2 = cur2.next;
                }
            }
            cur3.next = new ListNode(newVal);
            cur3 = cur3.next;
        }
        return dummyres.next;
    }
}