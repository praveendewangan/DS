package practice.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class _2ReverseLinkedListInGroup2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int d = Integer.parseInt(values1[i]);
            l1.addLast(d);
        }

        int k = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        l1.display();
        l1.kReverse(k);
        l1.display();
        l1.addFirst(a);
        l1.addLast(b);
        l1.display();
    }    
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addFirst(int data) {
            Node node = new Node(data);
            if(size == 0){
                this.head = node;
                this.tail = node;
            } else {
                node.next = head;
                head = node;
            }
            this.size++;
        }
        public void addLast(int data) {
            if(size == 0){
                addFirst(data);
            } else {
                Node node = new Node(data);
                tail.next = node;
                tail = node;
                size++;
            }
        }

        public void display() {
            Node cur = head;
            while(cur != null) {
                System.out.print(cur.data + " ");
                cur =cur.next;
            }
            System.out.println();
        }
        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }
        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }
        public void kReverse(int k){
            LinkedList pre = null;
            while(this.size > 0) {
                LinkedList curr = new LinkedList();
                if(this.size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(val);
                    }
                } else {
                    int os = this.size;
                    for (int i = 0; i < os; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }
                if(pre == null) {
                    pre = curr;
                } else {
                    pre.tail.next = curr.head;
                    pre.tail = curr.tail;
                    pre.size += curr.size;
                }
            }
            this.head = pre.head;
            this.tail = pre.tail;
            this.size = pre.size;
        }
    }
}
