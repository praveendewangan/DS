public class _10RemoveDuplicateInSortedList82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode cur = head;
        
        while(cur != null) {
            while(cur != null && cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(prev.next == cur){
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return temp.next;
    }

}
