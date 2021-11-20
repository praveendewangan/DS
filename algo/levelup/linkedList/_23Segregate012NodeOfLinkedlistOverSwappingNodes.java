import java.util.*;

class _23Segregate012NodeOfLinkedlistOverSwappingNodes {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode zero = new ListNode(-1);
        ListNode t0 = zero;
        ListNode one = new ListNode(-1);
        ListNode t1 = one;
        ListNode two = new ListNode(-1);
        ListNode t2 = two;
        while(head != null) {
            if(head.val == 0) {
                t0.next = head;
                t0 = t0.next;
            } else if(head.val == 1) {
                t1.next = head;
                t1 = t1.next;
            } else {
                t2.next = head;
                t2 = t2.next;
            }
            head = head.next;
        }
            t0.next = null;
            t1.next = null;
            t2.next = null;
            t1.next = two.next;
            t0.next = one.next;
        return zero.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate012(h1);
        printList(h1);
    }
}