import java.util.*;

class _28ReverseNodeOfLinkedlistInKGroup {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode dh = null;
        ListNode dt = null;
        int size = size(head);
        ListNode th = null;
        ListNode tt = null;
        ListNode cur = head;
        while(size >= k) {
            int len = k;
            while(len-- > 0) {
                ListNode next = cur.next;
                cur.next = null;
                if(th == null){
                    th = cur;
                    tt = cur;
                } else {
                    cur.next = th;
                    th = cur;
                }
                cur = next;
            }
            if(dh == null) {
                dh = th;
                dt = tt;
            } else {
                dt.next = th;
                dt = tt;
            }
            th = null;
            tt = null;
            size -= k;
        }
        dt.next = cur;
        
        return dh;
    }
    
    
    private static int size(ListNode head) {
        int c = 0;
        while(head != null) {
            c++;
            head = head.next;
        }
        return c;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}