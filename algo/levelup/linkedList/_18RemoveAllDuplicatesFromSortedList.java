import java.util.*;

class _18RemoveAllDuplicatesFromSortedList {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        
        ListNode cur = head;
        temp.next = cur;
        while(cur != null) {
            cur = cur.next;
            boolean flag = false;
            
            while(cur != null && temp.next.val == cur.val) {
                flag = true;
                cur = cur.next;
            }
            if(flag) {
                temp.next = cur;
            } else {
                temp = temp.next;
            }
        }
        
        return node.next;
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}