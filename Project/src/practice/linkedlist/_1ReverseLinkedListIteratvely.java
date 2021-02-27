package practice.linkedlist;

public class _2ReverseLinkedListIteratvely {
    // O(n),O(1)
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // list.head = new Node(85);
        // list.head.next = new Node(15);
        // list.head.next.next = new Node(4);
        // list.head.next.next.next = new Node(20);
        list.addLast(85).addLast(15).addLast(4).addLast(20);
 
        System.out.println("Given Linked list");
        list.print(list.head);
        list.head = list.reverse(list.head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.print(list.head);       
    }   
    public static class Node {
        int data;
        Node next;
        
        Node (int d) {
            this.data = d;
            this.next = null;
        }
    }
    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public Node reverse(Node node) {
            Node prev = null;
            Node current = node;
            Node next = null;
            while(current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            node = prev;
            return node;
        }

        public LinkedList addLast(int data) {
            Node node = new Node(data);
            if(size == 0) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
            return this;
        }

        public void print(Node node) {
            while(node != null) {
                System.out.print(node.data +" ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
