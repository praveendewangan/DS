import java.util.*;

class _24Segregate012NodeOfLinkedlistOverSwappingData {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

      public static void swapNodeData(ListNode n1, ListNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    public static ListNode segregate012(ListNode head) {
        ListNode i = head, j = head, k = head;
        // i -> first unsolved
        // j -> first 2
        // k -> first 1

        while(i != null) {
            if(i.val == 2) {
                i = i .next;
            } else if(i.val == 1) {
                // swap i, j
                swapNodeData(i, j);
                i = i.next;
                j = j.next;
            } else {
                // swap i, j
                swapNodeData(i, j);
                // swap j, k
                swapNodeData(j, k);
                i = i.next;
                j = j.next;
                k = k.next;
            }
        }
        return head;
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