import java.util.*;

class _20Segregate01NodeOfLinkedlistOverSwappingNodes {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
        ListNode l1 = new ListNode(-1);
        ListNode t1 = l1;
        ListNode l2 = new ListNode(-1);
        ListNode t2 = l2;
        
        while(head != null) {
            if(head.val == 1) {
                t2.next = head;
                t2 = t2.next;
            } else {
                t1.next = head;
                t1 = t1.next;
            }
            head = head.next;
        }
        t1.next = l2.next;
        return l1.next;
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
        h1 = segregate01(h1);
        printList(h1);
    }
}