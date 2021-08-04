import java.util.*;

class _8MergeSortLinkedList {
    // LC 148
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = midNode(head);
        ListNode node = mid.next;
        mid.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(node);
        return mergeTwoLists(l1,l2);
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
    
    private static ListNode getTail(ListNode node) {
        ListNode temp = node;
        while(node != null && node.next != null) {
            temp = node;
            node = node.next;
        }
        return temp;
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
        ListNode h1 = createList(n);

        ListNode head = mergeSort(h1);
        printList(head);
    }
}