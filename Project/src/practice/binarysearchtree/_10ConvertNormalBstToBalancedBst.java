package practice.binarysearchtree;

import java.util.Arrays;

public class _10ConvertNormalBstToBalancedBst {
    // O(nlogn),O(n)
    
    int idx = 0;
    public Node balanceBST(Node root) {
        int size = getSize(root);
        int[] a = new int[size];
        inorder(root,a);
        Arrays.sort(a);
        return createBalancedBst(a,0,a.length-1);
    }
    public int getSize(Node node) {
        return node == null ? 0 : (getSize(node.left) + getSize(node.right) + 1);
    }
    public void inorder(Node node,int[] a) {
        if(node == null) return;
        inorder(node.left,a);
        a[idx] = node.data;
        idx++;
        inorder(node.right,a);
    }
    public Node createBalancedBst(int[] a,int start,int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(a[mid]);
        node.left = createBalancedBst(a,start,mid-1);
        node.right = createBalancedBst(a,mid+1,end);
        return node;
    }
}
