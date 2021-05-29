public class _12KReverseLinkedList2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode th = null;
        ListNode tt = null;
        ListNode oh = null, ot = null;
        ListNode cur = head;
        int size = getSize(head);
         while(size >= k){
             int len = k;
             while(len-- > 0){
                ListNode forw = cur.next;
                cur.next = null;
                 // addFirstNode(cur);
                //  OR
                if(th == null) {
                    th = cur;
                    tt = cur;
                } else {
                    cur.next = th;
                    th = cur;
                }
                 cur = forw;
             }
             if(oh == null){
                 oh = th;
                 ot = tt;
             } else {
                 ot.next = th;
                 ot = tt;
             }
             th = null;
             tt = null;
             size -= k;
         }
        ot.next = cur;
        return oh;
    }
    private int getSize(ListNode node) {
        ListNode cur = node;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
}
