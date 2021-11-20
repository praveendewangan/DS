import java.util.*;

class _7MergeKSortedLinkedListDivideAndConqure {
    // LC 23
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    

      // Merge K Sorted LinkedList using divide and conq.
      public static ListNode mergeKLists(ListNode[] lists, int st, int end) {       
        if(st == end) return lists[st];
        int mid = (st + end) / 2;
        ListNode l1 = mergeKLists(lists, st, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(l1, l2); // merge two linkedlist is previously solved
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        
        if(l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }
        return node.next;
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}