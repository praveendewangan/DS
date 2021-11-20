import java.util.*;

class _19CopyLinkedListWithRandomPointerWithoutSpace {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        ListNode t1 = head;
        ListNode t2 = new ListNode(-1);
        ListNode temp = t2;
        while(t1 != null) {
            ListNode nn = new ListNode(t1.val);
            temp.next = nn;
            temp = temp.next;
            t1 = t1.next;
        }
        
        t1 = head;
        t2 = t2.next;
        
        while(t1 != null && t2 != null) {
            ListNode n1 = t1.next;
            ListNode n2 = t2.next;
            
            t1.next = t2;
            t2.next = n1;
            
            t1 = n1;
            t2 = n2;
        }
        t1 = head;
        
        while(t1 != null) {
            t1.next.random = t1.random == null ? null : t1.random.next;
            t1 = t1.next.next;
        }
        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);
        t1 = d1;
        t2 = d2;
        temp = head;
        while(temp != null) {
            t1.next = temp;
            t2.next = temp.next;
            
            t1 = t1.next;
            t2 = t2.next;
            temp = temp.next.next;
        }
        t1.next = null;
        t2.next = null;
        
        
        return d2.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}