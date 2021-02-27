package practice.linkedlist;

public class _26FlatteningLinkedList {
    // O(n*m),O(1)
    Node mergeSort(Node a,Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
                temp = temp.bottom;
        }
        if(a != null) {
            temp.bottom = a;
        } else if(b != null) {
            temp.bottom = b;
        }
        return res.bottom;
    }
    
    Node flatten(Node root) {
        if(root == null || root.next == null) {
            return root;
        }
        
        root.next = flatten(root.next);
        
        root = mergeSort(root,root.next);
        return root;
    }
}
