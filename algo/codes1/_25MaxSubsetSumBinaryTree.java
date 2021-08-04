public class _25MaxSubsetSumBinaryTree {
 
    class Pair {
        int inc;
        int exc;
        Pair(int inc,int exc) {
            this.inc = inc;
            this.exc = exc;
        }
        Pair() {
            this.inc = 0;
            this.exc = 0;
        }
    }
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    public static Pair maxSubsetSum(Node node) {
        Pair p = new Pair();
        if(node == null) {
            return p;
        }
        Pair l = maxSubsetSum(node.left);
        Pair r = maxSubsetSum(node.right);

        p.inc = node.data + l.exc + r.exc;
        p.exc = Math.max(l.inc, l.exc) + Math.max(r.inc, r.exc);
        return p;
    } 

    public static void main(String[] args) {
        Node root = new Node(0);
        Pair p = maxSubsetSum(root);
        System.out.println(Math.max(p.inc, p.exc));
    }
}
