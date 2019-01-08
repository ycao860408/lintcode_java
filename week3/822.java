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
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        reversadd(head);
        return res;
        
        
    }
    
    private void reversadd(ListNode head) {
        if (head == null) {
           return;
        }
        reversadd(head.next);
        res.add(head.val);
    }
}