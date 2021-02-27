package practice.linkedlist;

public class _8LastElementToFirst {
    // O(n),O(1)
    Node moveElement(Node root)
    {
        if(root == null || root.next == null){
            return root;
        }
	    Node temp = root;
	    
	    while(temp.next != null) {
	        temp = temp.next;
	    }
	    int data = temp.data;
	    temp.data = root.data;
	    root.data = data;
	    return root;
    }
}
