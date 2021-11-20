import java.util.*;

class _29ReverseInRange {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        if(head == null || head.next == null || m < n || n == m || n < 0) {
            return head;
        }
        int size = size(head);
        if(m > size || n > size){
            return head;
        }
        ListNode n1 = null;
        ListNode n2 = null;
        ListNode temp = head;
        for(int i = 1; i <= m; i++){
            if(i == n-1) {
                n1 = temp;
            }else if(i == m) {
                n2 = temp;
                break;
            }
            temp = temp.next;
        }
        n2 = n2.next;
        temp.next = null;
        
        ListNode prev = null;
        ListNode cur = n1 == null ? head : n1.next;
        ListNode tail = cur;
        if(n1 != null)
            n1.next = null;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        if(n1 != null) {
            n1.next = prev; 
        } else {
            head = prev;
        }
        tail.next = n2;
        return head;
    }
    
    private static int size(ListNode node) {
        int c = 0;
        while(node != null) {
            c++;
            node = node.next;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}