import java.util.Stack;

public class _1Construction {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(){}        
        public Node(int data) {    
            this.data = data;
        }
        public Node(int data,Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        Node node;
        int state;
        public Pair(){}
        public Pair(Node node,int state) {
            this.node = node;
            this.state = state;
        }

    }
    public static Node construct(Integer[] a) {
        Stack<Pair> st = new Stack<>();
        Node node = new Node(a[0]);
        st.push(new Pair(node,0));
        int idx = 0;

        while(!st.empty()) {
            Pair p = st.peek();
            if(p.state == 0) {
                idx++;
                if(a[idx] != null) {
                    Node nn = new Node(a[idx]);
                    p.node.left = nn;
                    st.push(new Pair(nn,0));    
                }
                p.state++;
            } else if(p.state == 1) {
                idx++;
                if(a[idx] != null) {
                    Node nn = new Node(a[idx]);
                    p.node.right = nn;
                    st.push(new Pair(nn,0));    
                }
                p.state++;
            } else {
                st.pop();
            }
        }
        return node;
    }

    public static void display(Node node) {
        if(node == null) return;
        
        System.out.println((node.left == null ? "." : node.left.data) + " <- " + node.data + " -> " + (node.right == null ? "." : node.right.data));
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(arr);
        display(root);
    }
}
