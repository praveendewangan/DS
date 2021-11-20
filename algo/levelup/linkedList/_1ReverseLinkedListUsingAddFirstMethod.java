
import java.util.*;

class _1ReverseLinkedListUsingAddFirstMethod {
    // LC 206
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode thead;
    static ListNode ttail;

    public static void addFirst(ListNode node) {
        if(thead == null) {
            thead = ttail = node;
        } else {
            node.next = thead;
            thead = node;
        }
    }

    public static ListNode reverseUsingAddFirst(ListNode head) {
        thead = ttail = null;
        ListNode next = head;
        while(next != null) {
            ListNode i = next;
            next = i.next;
            i.next = null;
            addFirst(i);
        }
        return thead;
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

        ListNode head = reverseUsingAddFirst(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
head = head.next;
        }
    }
}