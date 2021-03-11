package practice.binarysearchtree;

public class _13KthSmallestElementInBST {
    // O(n),O(1)
    int count = 0;
    // Return the Kth smallest element in the given BST 
    public int KthSmallestElement(Node root, int k) 
    {
        Node node = helper(root,k);
        if(node == null) {
            return -1;
        } else {
            return node.data;
        }   
    }
    
    public Node helper(Node node,int k) {
        if(node == null) {
            return null;
        }
        Node l = helper(node.left,k);
        if(l != null) {
            return l;
        }
        count++;
        if(count == k) {
            return node;
        }
        return helper(node.right,k);
        
    }
}
