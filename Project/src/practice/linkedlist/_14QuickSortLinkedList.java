package practice.linkedlist;

public class _14QuickSortLinkedList {
    // O(nlogn) || O(n^2),O(1)
    public static Node quickSort(Node node)
    {
        Node end = getEnd(node);
        qsort(node,end);
        return node;
    }
    public static void qsort(Node start,Node end) {
        if(start == null || start == end || start == end.next) {
            return;
        }
        Node prev = partition(start,end);
        qsort(start,prev);
        
        if(prev != null && prev == start) {
            qsort(prev.next,end);
        } else if(prev != null && prev.next != null){
            qsort(prev.next.next,end);
        }
    }
    public static Node partition(Node start,Node end) {
        if(start == null || end == null || start == end) {
            return start;
        }
        Node pivot = start;
        Node cur = start;
        int data = end.data;
        
        while(start != end) {
            if(start.data < data) {
                pivot = cur;
                int temp = cur.data;
                cur.data = start.data;
                start.data = temp;
                cur = cur.next;
            }
            start = start.next;
        }
        int temp = cur.data;
        cur.data = data;
        end.data = temp;
        return pivot;
    }
    public static Node getEnd(Node node) {
        Node temp = node;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }
    
}
