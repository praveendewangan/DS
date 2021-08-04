import java.util.*;

class _3PalindromeLinkedList {
    // LC 234
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode temp = midNode(head);
        ListNode mid = reverse(temp.next);
        temp.next = null;
        while(head != null && mid != null){
            if(head.val != mid.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
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
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        System.out.println(isPalindrome(dummy.next));
    }
}