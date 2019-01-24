/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, cur = head, newNode;
        
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur,new RandomListNode(cur.label));
            }

            if (!map.containsKey(cur.random)) {
                map.put(cur.random, cur.random== null ? null : new RandomListNode(cur.random.label));
            }
            newNode = map.get(cur);
            newNode.random = map.get(cur.random);
            pre.next = newNode;
            pre = newNode;
            cur = cur.next;
        }
        return dummy.next;
    }
}