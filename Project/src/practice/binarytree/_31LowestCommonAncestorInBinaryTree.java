package practice.binarytree;

public class _31LowestCommonAncestorInBinaryTree {
    // O(n),O(1);
    Node lca(Node root, int n1,int n2)
	{
		Node node = getLca(root,n1,n2);
		    return node;
	}
	Node getLca(Node node,int n1,int n2) {
	    if(node == null) {
	        return null;
	    }
	    if(node.data == n1 || node.data == n2) {
	        return node;
	    }
	    Node leftNode = getLca(node.left,n1,n2);
	    Node rightNode = getLca(node.right,n1,n2);
	    
	    if(leftNode != null && rightNode != null){
	        return node;
	    }
	    return leftNode != null ? leftNode : rightNode;
	}
}
