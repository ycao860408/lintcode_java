public class Solution {
    /**
     * @param head: the given linked list
     * @return:  the weighted sum in reverse order
     */
    int order = 0, sum = 0;
    
    public int weightedSumReverse(ListNode head) {
        // write your code here
        cal(head);
        return sum;
    }
    
    void cal(ListNode head) {
        if (head == null) {
            return;
        }
        cal(head.next);
        sum += head.val * (++order);
        
    }
}