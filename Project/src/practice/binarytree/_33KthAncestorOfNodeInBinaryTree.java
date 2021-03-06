package practice.binarytree;

public class _33KthAncestorOfNodeInBinaryTree {
    // O(n),O(1)
    static int k = 0;
    public static void main(String args[]) { 
        // Let us create binary tree shown in above diagram 
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
    
        k = 2; 
        int node = 5; 
    
        // print kth ancestor of given node 
        Node parent = kthAncestorDFS(root,node); 
        
        // check if parent is not null, it means 
        // there is no Kth ancestor of the node 
        if (parent != null) 
            System.out.println("-1"); 
    }    

    static Node kthAncestorDFS(Node node,int n) {
        if(node == null) {
            return null;
        }
        if(node.data == n || kthAncestorDFS(node.left,n) != null || kthAncestorDFS(node.right,n) != null) {
            if(k > 0) {
                k--;
            } else if(k == 0) {
                System.out.println(node.data);
                return null;
            }
            return node;
        }
        return null;
    }
}
