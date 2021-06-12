public class _20MergeKSortedLinkedList {
    
    class Pair implements Comparable<Pair>{
        ListNode node;
        int slot;
        int idx;
        Pair(ListNode node,int slot,int idx) {
            this.node = node;
            this.slot = slot;
            this.idx = idx;
        }
        Pair(ListNode node) {
            this.node = node;
        }
        public int compareTo(Pair p){
            return this.node.val - p.node.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode();
        if(lists == null || lists.length == 0) return null;
        ListNode temp = node;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) {
              pq.add(new Pair(lists[i]));
            }
        }
    
        while(pq.size() > 0){
            Pair rm = pq.remove();
            temp.next = rm.node;
            temp = temp.next;
            ListNode n = rm.node.next;
            if(n != null){
                pq.add(new Pair(n));
            }
        }
        return node.next;
    }
}
