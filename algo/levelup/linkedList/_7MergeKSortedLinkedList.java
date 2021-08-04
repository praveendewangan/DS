import java.util.*;

class _7MergeKSortedLinkedList {
    // LC 23
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while(pq.size() > 0 ) {
            ListNode rm = pq.remove();
            temp.next = rm;
            if(rm.next != null){
                pq.add(rm.next);
            }
            // rm.next = null;
            temp = temp.next;
        }
        return node.next;
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}