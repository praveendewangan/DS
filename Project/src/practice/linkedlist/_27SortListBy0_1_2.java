package practice.linkedlist;

public class _27SortListBy0_1_2 {
    // O(n),O(1)
    static Node segregate(Node head)
    {
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        Node temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                c1++;
            } else if(temp.data == 1) {
                c2++;
            } else {
                c3++;
            }
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null && c1 != 0) {
            temp.data = 0;
            temp = temp.next;
            c1--;
        }
        while(temp != null && c2 != 0) {
            temp.data = 1;
            temp = temp.next;
            c2--;
        }
        while(temp != null && c3 != 0) {
            temp.data = 2;
            temp = temp.next;
            c3--;
        }
        return head;
        
    }
}
