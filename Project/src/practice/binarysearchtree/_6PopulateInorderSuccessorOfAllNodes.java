package practice.binarysearchtree;

public class _6PopulateInorderSuccessorOfAllNodes {
    // O(n),O(1)
    static Node prev = null;
    public static void populateNext(Node root)
    {
        
        if(root==null)
            return ;
        populateNext(root.left);
        if(prev!=null){
            prev.next=root;
        }
        prev=root;
        populateNext(root.right);
    }
}
