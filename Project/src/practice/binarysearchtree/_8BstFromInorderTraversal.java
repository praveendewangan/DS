package practice.binarysearchtree;

public class _8BstFromInorderTraversal {
    // O(n),O(1)
    public Node bstFromPreorder(int[] preorder) {
        return create(preorder,0, preorder.length-1);
    }
    public Node create(int[] a,int start,int end) {
        if(start > end) {
            return null;
        }
        Node node = new Node(a[start]);
        int i;
        for(i=start+1;i<=end;i++) {
            if(a[i]>node.data) {
                break;
            }
        }
        node.left = create(a,start+1,i-1);
        node.right = create(a,i,end);
        return node;
    }
}
