import java.util.*;

class _22SegregateEvenAndOddNodesInALinkedlist {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode t1 = odd;
        ListNode even = new ListNode(-1);
        ListNode t2 = even;
        
        while(head != null) {
            if(head.val % 2 == 0) {
                t2.next = head;
                t2 = t2.next;
            } else {
                t1.next = head;
                t1 = t1.next;
            }
            head = head.next;
        }
        t1.next = null;
        t2.next = null;
        t2.next = odd.next;
        return even.next;
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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}