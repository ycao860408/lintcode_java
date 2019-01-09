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
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> listNodeQueue = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode item : lists) {
            if (item != null) {
                listNodeQueue.offer(item);
            }
        }
        
        ListNode dummy = new ListNode(0), cur = dummy;
        
        while (!listNodeQueue.isEmpty()) {
            ListNode temp = listNodeQueue.poll();
            cur.next = temp;
            if (temp.next != null) {
                listNodeQueue.offer(temp.next);
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}

class ListNodeComparator implements Comparator<ListNode> {
    public int compare(ListNode a, ListNode b) {
        return a.val - b.val;
    }
}
