package practice.linkedlist;

public class _31DeleteNodeHavingGreaterValueToTheRight {
    // O(n),O(1)
    Node compute(Node head)
    {
        Node temp = head;
        while(temp != null && temp.next != null){
            
            //Copying next node data into current node
              //i.e. we are indirectly deleting current node
            if(temp.data < temp.next.data){
                temp.data = temp.next.data;
                temp.next = temp.next.next;
            }
            else{
                  //move to the next node
                temp = temp.next;
            }
        }
        return head;
    }
}
