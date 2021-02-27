package practice.linkedlist;

public class Node {
    Integer data;
    Node next;
    Node prev;
    Node bottom;
    Node(Integer data) {
        this.data = data;
        this.next = null;
        this.prev = null; 
    }
    Node() {
        this.data = null;
        this.next = null;
        this.prev = null; 
    }
}
