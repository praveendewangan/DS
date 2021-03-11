package practice.binarysearchtree;

public class _7LCAinBST {
    // O(h),O(1)
    Node LCA(Node node, int n1, int n2)
	{
        if(node == null) {
            return null;
        }
        if(node.data > n1 && node.data > n2){
            return LCA(node.left,n1,n2);
        } else if(node.data < n1 && node.data < n2){
            return LCA(node.right,n1,n2);
        } else {
            return node;
        }
    }
}
