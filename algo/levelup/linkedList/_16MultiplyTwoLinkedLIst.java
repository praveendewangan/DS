import java.util.*;

class _16MultiplyTwoLinkedLIst {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);
        int zeroCount = 0;
        ListNode sumNode = null;
        while(t2 != null) {
            int zc = zeroCount;
            zeroCount++;
            ListNode temp = new ListNode(-1);
            ListNode n = multiply(t1,t2.val);
            // printList(n);
            // System.out.println();
            while(zc-- > 0) {
                ListNode zeroNode = new ListNode(0);
                zeroNode.next = n;
                n = zeroNode;
            }
            // printList(n);
            // System.out.println();
            sumNode = addTwoNumbers(n,sumNode);
            t2 = t2.next;
        }
        
        return reverse(sumNode);
    }
    
    private static ListNode multiply(ListNode node,int data) {
        int carry = 0;
        ListNode n = new ListNode(-1);
        ListNode temp = n;
        while(node != null || carry != 0) {
            int v1 = node == null ? 0 : node.val;
            int val = v1 * data + carry;
            carry = val / 10;
            val = val % 10;
            ListNode nn = new ListNode(val);
            temp.next = nn;
            temp = nn;
            node = node == null ? node : node.next;
        }
        
        return n.next;
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        int c = 0;
        while(l1 != null || l2 != null || c != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + c;
            c = sum / 10;
            sum = sum % 10;
            ListNode nn = new ListNode(sum);
            temp.next = nn;
            temp = temp.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return node.next;
    }
    
     private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
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
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}