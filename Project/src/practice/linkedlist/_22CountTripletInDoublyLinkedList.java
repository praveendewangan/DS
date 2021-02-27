package practice.linkedlist;

public class _2CountTripletInDoublyLinkedList {
    // O(n^2),O(1)
    
    public static void main(String[] args) {
        // start with an empty doubly linked list
        Node head = null;
    
        // insert values in sorted order
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);
    
        int x = 17;
    
        System.out.print("Count = "
            + countTriplets(head, x));
    }
    static int countTriplets(Node head,int x) {
        int count = 0;
        Node cur = head;
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        while(cur != null) {
            count += countPair(cur.next,last,x-cur.data);
            cur = cur.next;
        }
        return count;
    }
    static int countPair(Node first,Node last,int x) {
        int count = 0;
        Node second = last;
        boolean flag = false;
        while(first != null && second != null && first != second && second.next != first){
            if((first.data + second.data) == x) {
                // System.out.println(first.data +","+second.data);
                first = first.next;
                second = second.prev;
                count++;
            } else if((first.data+second.data) < x) {
                first = first.next;
            } else {
                second = second.prev;
            }
        }
        return count;
    }
    static void pairSum(Node head,int x) {
        Node first = head;
        Node second = head;
        while(second.next != null) {
            second = second.next;
        }
        boolean flag = false;
        while(first != null && second != null && first != second && second.next != first){
            if((first.data + second.data) == x) {
                System.out.println(first.data +","+second.data);
                first = first.next;
                second = second.prev;
                flag = true;
            } else if((first.data+second.data) < x) {
                first = first.next;
            } else {
                second = second.prev;
            }
        }
        if(!flag) {
            System.out.println("No pair found!");
        }
    }
    static Node insert(Node head, int data) { 
        Node temp = new Node(-1); 
        temp.data = data; 
        temp.next = temp.prev = null; 
        if (head == null) 
            (head) = temp; 
        else
        { 
            temp.next = head; 
            (head).prev = temp; 
            (head) = temp; 
        } 
        return temp; 
    } 

}
