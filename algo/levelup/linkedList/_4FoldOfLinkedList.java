import java.util.*;

class _4FoldOfLinkedList {
    // LC 143
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void fold(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode h1 = head;
        ListNode mid = midNode(head);
        ListNode h2 = reverse(mid.next);
        mid.next = null;
        
        while(h1 != null && h2 != null) {
            ListNode t1 = h1.next;
            ListNode t2 = h2.next;
            
            h1.next = h2;
            h2.next = t1;
            h1 = t1;
            h2 = t2;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    public static ListNode midNode(ListNode head) {
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}