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
        if (head == null) {
            return null;
        }
        
        RandomListNode copy = null;
        RandomListNode cur = head;
        
        while ( cur != null) {
            copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        /*
        while (head != null) {
            System.out.println(head.label);
            head = head.next;
        }
        */
        cur = head;
        
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        RandomListNode cur1 = head, cur2 = head.next;
        while (cur2.next != null) {
            RandomListNode temp1 = cur2.next;
            RandomListNode temp2 = temp1.next;
            cur1 = temp1;
            cur2.next = temp2;
            cur2 = temp2;
        }
        
        return head.next;
    }
}


// Someother's 

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) return null;
        RandomListNode copiedList = copyList(head);
        RandomListNode addRandom = copyRandom(head);
        return splitCopyied(addRandom);
        
    }
    
    private RandomListNode copyList(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode; 
            cur = cur.next.next;
        }
        return head;
    }
    
    private RandomListNode copyRandom(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        return head;
    }
    
    private RandomListNode splitCopyied(RandomListNode head) {
        RandomListNode newNode = head.next, cur = head.next;
        while (cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        
        return newNode;

    }
}