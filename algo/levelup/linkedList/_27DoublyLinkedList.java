public class _27DoublyLinkedList {
    class Node {
        Node prev;
        Node next;
        int data;

        public Node() {

        }
        public Node(int data) {
            this.data = data;
        }

        public Node(int data,Node prev,Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private int size() {
        return size;
    }
    public void addFirst(int data) {
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn;
        } else {
            nn.next = head;
            head.prev = nn;
            head = nn;
        }
        size++;
    }

    public void addLast(int data) {
        if(head == null){
            addFirst(data);
        } else {
            Node nn = new Node(data);
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
            size++;
        }
    }
    
    public void addAt(int data,int idx) {
        if(idx < 0 || idx > size()){
            System.out.println("Invalid");
        } else if(idx == 0) {
            addFirst(data);
        } else if(idx == size()){
            addLast(data);
        } else {
            Node nn = new Node(data);
            Node prevNode = getNodeAt(idx-1);
            Node nextNode = prevNode.next;
            prevNode.next = nn;
            nn.prev = prevNode;
            nn.next = nextNode;
            nextNode.prev = nn;
            size++;
        }
    }

    public void addBefore(Node node,int data) {
        if(node == head){
            addFirst(data);
        } else {
            Node nn = new Node(data);
            nn.next = node;
            node.prev.next = nn;
            nn.prev = node.prev;
            node.prev = nn;
            size++;
        }
    }

    public void addAfter(Node node,int data) {
        if(node == tail) {
            addLast(data);
        } else {
            Node nn = new Node(data);
            nn.prev = node;
            nn.next = node.next;
            node.next.prev = nn;
            node.next = nn;
            size++;
        }
    }

    private Node getNodeAt(int idx) {
        if(size() == 0 || idx == size()) {
            return null;
        } else {
            Node node = null;
            Node temp = head;
            for(int i = 0; i <= idx; i++) {
                node = temp;
                temp = temp.next;
            }
            return node;
        }
    }

    private int removeFirst() {
        if(size() == 0) {
            return -1;
        } else if(size() == 1) {
            Node n = head;
            head = tail = null;
            size--;
            return n.data;
        } else {
            Node n = head;
            head = head.next;
            n.next = null;
            size--;
            return n.data;
        }
    }

    private int removeLast() {
        if(size() == 0) {
            return -1;
        } else if(size() == 1) {
            Node n = head;
            head = tail = null;
            size--;
            return n.data;
        } else {
            Node n = tail;
            tail.next = null;
            tail = tail.prev;
            n.prev = null;
            size--;
            return n.data;
        }
    }

    private int removeAt(int idx) {
        if(idx < 0 || idx >= size() || size() == 0) {
            return -1;
        } else if(idx == 0) {
            return removeFirst();
        } else if(idx == size() - 1) {
            return removeLast();
        } else {
            Node n = getNodeAt(idx);
            Node prevNode = n.prev;
            Node nextNode = n.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
            return n.data;
        }
    }
    
    private int removeBefore(Node node) {
        if(node == null || node.prev == null) {
            return -1;
        } else if(head == node.prev) {
            return removeFirst();
        } else {       
            Node n = node.prev;
            Node prev = node.prev.prev;
            node.prev = prev;
            prev.next = node;
            n.next = null;
            n.prev = null;
            size--;
            return n.data;
        }
    }
    
    private int removeAfter(Node node) {
        if(node == null || node.next == null) {
            return -1;
        } else if(tail == node.next) {
            return removeLast();
        } else {      
            Node n = node.next;
            Node next = node.next.next;
            node.next = next;
            next.prev = node;
            n.prev = null;
            n.next = null;
            size--;
            return n.data;
        }
    }

    private int removeNode(Node node) {
        if(node == null) {
            return -1;
        } else if(node == head) {
            return removeFirst();
        } else if(node == tail) {
            return removeLast();
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
            node.prev = null;
            node.next = null;
            return node.data;
        }
    }

    private int getFirst() {
        if(size() == 0) {
            return -1;
        } else {
            return head.data;
        }
    }

    private int getLast() {
        if(size() == 0) {
            return -1;
        } else {
            return tail.data;
        }
    }

    private int getAt(int idx) {
        if(size() == 0 || idx < 0 || idx >= size()) {
            return -1;
        } else {
            return getNodeAt(idx).data;
        }
    }

    private void forwardDisplay() {
        if(size() == 0) {
            System.out.println("[]");
        } else {
            Node temp = head;
            System.out.print("[");
            while(temp.next != null) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
            System.out.println(temp.data+"]");
        }
    }

    private void backwardDisplay() {
        if(size() == 0) {
            System.out.println("[]");
        } else {
            Node temp = tail;
            System.out.print("[");
            while(temp.prev != null) {
                System.out.print(temp.data + ", ");
                temp = temp.prev;
            }
            System.out.println(temp.data+"]");
        }
    }



}
