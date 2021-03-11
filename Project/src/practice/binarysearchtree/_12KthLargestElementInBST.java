package practice.binarysearchtree;

public class _12KthLargestElementInBST {
    // O(n),O(1)
    int count = 0;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int k)
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
        Node r = helper(node.right,k);
        if(r != null) {
            return r;
        }
        count++;
        if(count == k) {
            return node;
        }
        return helper(node.left,k);
        
    }
}
