import java.util.*;

class _5UnFoldLinkedList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {
        if(head == null) return;
        ListNode t1 = head;
        ListNode h1 = t1;
        ListNode t2 = head.next;
        head.next = null;
        ListNode h2 = t2;
        int count = 0;
        while(t2 != null && t2.next != null) {
            if(count % 2 == 0) {
                t1.next = t2.next;
                t1 = t1.next;
            } else {
                t2.next = t1.next;
                t2 = t2.next;
            }
            count++;
        }
        t1.next = null;
        t1.next = reverse(h2);
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
    
    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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
        unfold(head);
        printList(head);
    }
}