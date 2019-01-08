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
     * @param head: the head of linked list.
     * @return: An integer list
     */
    public List<Integer> toArrayList(ListNode head) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        ListNode cur = head;
        
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        
        return res;
    }
}