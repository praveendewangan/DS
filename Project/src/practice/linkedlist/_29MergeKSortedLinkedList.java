package practice.linkedlist;

public class _29MergeKSortedLinkedList {
    // O(nlogK),O(1)
    Node mergeSort(Node a,Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            } /*else {
                temp.next = a;
                // temp = temp.next;
                // temp.next = b;
                a = a.next;
                b = b.next;
            }*/
            temp = temp.next;
        }
        while(a != null) {
            temp.next = a;
            temp = temp.next;
            a = a.next; 
        }
        while(b != null) {
            temp.next = b;
            temp = temp.next;
            b = b.next; 
        }
        return res.next;
    }
    Node mergeKList(Node[]a,int N)
    {
        N = N-1;
        while(N != 0) {
            int i = 0;
            int j = N;
            while(i < j) {
                a[i] = mergeSort(a[i],a[j]);
                i++;
                j--;
                if(i>=j) {
                    N = j;
                    break;
                }
            }
        }
        return a[0];
    }
}
