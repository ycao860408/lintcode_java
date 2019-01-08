/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param nums: an integer array
     * @return: the first node of linked list
     */
    public ListNode toLinkedList(List<Integer> nums) {
        // write your code here
       if (nums == null || nums.size() == 0) {
           return null;
       }
       
       ListNode dummy = new ListNode(0), cur = dummy;
       
       for (Integer item : nums) {
           cur.next = new ListNode(item.intValue());
           cur = cur.next;
       }
       return dummy.next;
    }
}