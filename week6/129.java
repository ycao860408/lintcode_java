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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return new ListNode[0];
        }
        ListNode[] newHashTable = new ListNode[2 * hashTable.length];
        int n = newHashTable.length;
        for (int i = 0; i < hashTable.length; i++) {
            ListNode cur = hashTable[i];
            while (cur != null) {
                int idx = (cur.val % n + n) % n;
                ListNode temp = new ListNode(cur.val);
                ListNode pre = null, ncur = newHashTable[idx];
                if (ncur == null) {
                    newHashTable[idx] = temp;
                } else {
                    while (ncur!= null) {
                        pre = ncur;
                        ncur = ncur.next;
                    }
                    pre.next = temp;
                }
                cur = cur.next;
            }
        }
        return newHashTable;
    }
    
};
