package practice.linkedlist;

public class _6RemoveDuplicateInLinkedList {
    // O(n),O(1)
    Node removeDuplicates(Node root)
    {
        if(root == null || root.next == null){
            return root;
        }
	    Node temp = root;
	    
	    while(temp != null && temp.next != null) {
	        if(temp.data != temp.next.data){
	            temp = temp.next;
	        } else {
	            temp.next = temp.next.next;
	        }
	    }
	    return root;
    }
}
