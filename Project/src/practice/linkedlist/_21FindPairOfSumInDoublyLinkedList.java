package practice.linkedlist;

public class _21FindPairOfSumInDoublyLinkedList {
    // O(n),O(1)

    public static void main(String[] args) {
        Node head = null; 
        head = insert(head, 9); 
        head = insert(head, 8); 
        head = insert(head, 6); 
        head = insert(head, 5); 
        head = insert(head, 4); 
        head = insert(head, 2); 
        head = insert(head, 1); 
        int x = 7; 
        pairSum(head, x); 
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
