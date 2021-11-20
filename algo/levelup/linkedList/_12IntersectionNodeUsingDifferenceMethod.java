import java.util.*;

class _12IntersectionNodeUsingDifferenceMethod {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        int s1 = size(headA);
        int s2 = size(headB);

        if(s1 > s2){
            int dif = s1 - s2;
            while(dif-- > 0) {
                headA = headA.next;
            }
        } else if(s2 > s1) {
            int dif = s2 - s1;
            while(dif-- > 0) {
                headB = headB.next;
            }
        }

        while(headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
            if(headA == headB) {
                return headA;
            }
        }
        return null;
    }

    private static int size(ListNode node) {
        int count = 0;
        while(node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    // Input_code===================================================

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

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}