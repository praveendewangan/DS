class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class _3ReverseLinkedList92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        int i = 1;
        while(i < left) {
            prev = prev.next;
            cur = cur.next;
            i++;
        }
        ListNode node = prev;
        
        while(i <= right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        node.next.next = cur;
        node.next = prev;
        return dummy.next;
    }
}
