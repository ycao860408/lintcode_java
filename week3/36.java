public class Solution {
    /**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode reverseHead = dummy;
        for (int i = 0 ; i < m -1; i++) {
            reverseHead = reverseHead.next;
        }
        
        // reversehead 是 1；
        ListNode prev = reverseHead.next; //2
        ListNode cur = prev.next; //3
        ListNode front = reverseHead;
        ListNode end = reverseHead.next; // 一直没变。
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // 3 connect 
        front.next = prev;
        end.next = cur;
        return dummy.next;
    }
}