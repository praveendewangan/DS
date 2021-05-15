
class LinkedList {
    private class Node {
        private int data;
        private Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data,Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        if(size() == 0){
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addLast(int val) {
        Node node = new Node(val);
        if(size() == 0){
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.size++;
    }

    
    public int getFirst() {
        if(size() == 0) {
            return -1;
        } else {
            return this.head.data;
        }
    }
    
    public int getLast() {
        if(size() == 0) {
            return -1;
        } else {
            return this.tail.data;
        }
    }

    public void addAt(int val,int idx){
        if(idx < 0 || idx > size()) {
            System.out.println("Invalid index");
        } else if(idx == 0) {
            addFirst(val);
        } else if(idx == size()) {
            addLast(val);
        } else {
            Node temp = getNodeAt(idx - 1);
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
            this.size++;
        }
    }

    private Node getNodeAt(int idx) {
        Node temp = this.head;
        while(idx > 0) {
            temp = temp.next;
            idx--;
        }
        return temp;
    }

    public void display() {
        Node temp = this.head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getAt(int idx) {
        if(idx < 0 || idx >= size()) {
            return -1;
        } else {
            return getNodeAt(idx).data;
        }
    } 

    public int removeFirst() {
        if(size() == 0) {
            return -1;
        } else if(size() == 1) {
            int val = getFirst();
            this.head = this.tail = null;
            this.size--;
            return val;
        } else {
            int val = getFirst();
            this.head = this.head.next;
            this.size--;
            return val;
        }
    }

    public int removeLast(){
        if(size() == 0) {
            return -1;
        } else if(size() == 1) {
            return removeFirst();
        } else {
            Node node = getNodeAt(size() - 2);
            int val = this.tail.data;
            node.next = null;
            this.tail = node;
            this.size--;
            return val;
        }
    }

    public int removeAt(int idx) {
        if(idx < 0 || idx >= size()) {
            return -1;
        } else if(idx == 0) {
            return removeFirst();
        } else if(size() - 1 == idx) {
            return removeLast();
        } else {
            Node node = getNodeAt(idx - 1);
            int val = node.next.data;
            node.next = node.next.next;
            this.size--;
            return val;
        }
    }

    public int size() {
        return this.size;
    }
}

public class _1LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.display();
        list.addLast(30);
        list.addFirst(9);
        list.display();
        list.addFirst(7);
        list.addLast(40);
        list.display();
        System.out.println(list.size());

        System.out.println(list.removeFirst());
        list.addAt(40, 2);
        list.display();

        System.out.println(list.removeAt(3));
        System.out.println(list.getAt(3));
        list.addLast(90);
        list.addLast(85);
        list.addLast(40);
        list.addLast(70);
        list.addLast(60);

        list.display();

        System.out.println(list.size());
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeAt(3);
        list.display();

        list.removeLast();
        list.removeLast();
        list.display();

    }
}
