class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class LinkList{
    ListNode head;
    LinkList() {
        head = null;
    }
    
    LinkList(int val) {
        head = new ListNode(val);
    }
    
    LinkList(LinkList link) {
        ListNode dummy = new ListNode(0);
        ListNode curl = link.head, cur = dummy;
        while (curl != null) {
            cur.next = new ListNode(curl.val);
            curl = curl.next;
            cur = cur.next;
        }
        head = dummy.next;
    }
    
    void insert(int val) {
        ListNode dummy = new ListNode(0);
        ListNode temp = new ListNode(val);
      	dummy.next = temp;
    	temp.next = head;
      	head = dummy.next;
    }
    
    boolean search(int val) {
        ListNode cur = head;
        while (cur != null&& cur.val != val) {
            cur = cur.next;
        }
        if (cur == null) {
            return false;
        }
        return true;
    }
    
    void delete(int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur!= null) {
            
            if (cur.val == val) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("There is no such value in the linkedlist");
        } else {
            pre.next = cur.next;
        }
        head = dummy.next;
    }
    
    void deleteIndex(int index) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
           
            count ++;
            if (count == index) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("There is no such index in the linkedlist");
        } else {
            pre.next = cur.next;
        }
        head = dummy.next;
        
    }
    
    void print() {
        if (head == null) {
            System.out.println("This is an empty linkedlist.");
        } else {
            ListNode cur = head;
            while (cur != null) {
                System.out.print(cur.val + " ");
              	cur = cur.next;
            }
            System.out.println();
        }
        
    }
}

public class LinkedListDemo{
    public static void main(String args[]) {
        LinkList l1 = new LinkList(0);
      	l1.print();
      	int nums[] = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < nums.length; i++) {
            l1.insert(nums[i]);
        }
      	l1.print();
      	System.out.println(l1.search(20));
      	l1.delete(0);
      	l1.print();
      	l1.deleteIndex(1);
      	l1.print();
      	LinkList l2 = new LinkList(l1);
      	l2.print();
        
    }
}