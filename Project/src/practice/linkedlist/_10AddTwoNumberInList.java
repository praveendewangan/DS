package practice.linkedlist;

public class _10AddTwoNumberInList {
    // O(n+m),O(max(n,m))

    static Node addTwoLists(Node first, Node second){
        Node node = new Node(0);
        // first = reverseList(first);
        // second = reverseList(second);
        int s1 = getSize(first);
        int s2 = getSize(second);
        int c = addNodes(first,s1,second,s2,node);
        if(c > 0) {
            Node head = new Node(c);
            head.next = node.next;
            node.next = head;
        }
        return node.next;
    }
    static int getSize(Node node) {
        Node temp = node;
        int count = 1;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
   
    static int addNodes(Node first,int s1,Node second,int s2,Node node) {
        if(first == null && second == null){
            return 0;
        }
        int data = 0;
        if(s1 == s2){
            int oc = addNodes(first.next,s1-1,second.next,s2-1,node); 
            data = first.data + second.data + oc;
        } else if(s1 > s2) {
            int oc = addNodes(first.next,s1-1,second,s2,node); 
            data = first.data + oc; 
        } else {
            int oc = addNodes(first,s1,second.next,s2-1,node); 
            data = second.data + oc; 
        }
        int nd = data % 10;
        Node head = new Node(nd);
        head.next = node.next;
        node.next = head;
        return data / 10;
    }
}
