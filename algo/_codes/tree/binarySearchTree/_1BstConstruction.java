import jdk.internal.org.jline.utils.Display;

public class _1BstConstruction {
    
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node construct(int[] a,int lo,int hi) {
        if(lo > hi) return null;
        int m = (lo + hi)/2;
        Node node = new Node(a[m]);
        node.left = construct(a, lo, m - 1);
        node.right = construct(a, m + 1, hi);
        return node;
    }

    public static void display(Node node) {
        if(node == null) return;
        System.out.println((node.left != null ? node.left.data : ".") + " <- " + node.data + " -> " + (node.right != null ? node.right.data : "."));
        display(node.left);
        display(node.right);
    }
    public static void main(String[] args) {
        int[] a = {10,20,30,40,50,60,70,80,90};
        Node root = construct(a,0,a.length - 1);
        display(root);
    }
}
