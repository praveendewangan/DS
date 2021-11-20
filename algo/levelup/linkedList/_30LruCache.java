import java.util.HashMap;
import java.util.Map;

class _30LruCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node() {

        }
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }

    }
    
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    private int cap = 0;
    
    
    Map<Integer,Node> map = null;
    public _30LruCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
    }
    
    public void addLast(Node node) {
        if(this.size == 0){
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        this.size++;
    }
    
    
    public int removeFirst() {
        Node rm = head;
        head = head.next;
        head.prev = null;
        rm.next = null;
        this.size--;
        return rm.key;
    }
    
    
    public void removeNode(Node node) {
        if(this.size == 1) {
            this.head = this.tail = null;
        } else if(node == head) {
            head = head.next;
            head.prev = null;
        } else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        this.size--;
    }
    
    
    
    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.get(key).value;
//             call put to update
            this.put(key,value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addLast(node);
        } else {
            // insertion
            // 1. add new application recent tab
            Node node = new Node(key,value);
            map.put(key,node);
            addLast(node);
            
            // 2. if no. of tab cross capacity then remove least  used app (remove first)
            if(this.size > this.cap) {
                int rmKey = removeFirst();
                map.remove(rmKey);
            }
        }
    }
}
class lru {
    public static void main(String[] args) {
        
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    }    
}

