package generictree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class _27IterableAndIterator {
    public static class GenericTree implements Iterable<Integer> {
        Node root;
        public GenericTree(Node node) {
            root = node;
        }
        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }
    }
    public static class GTPreorderIterator implements Iterator<Integer> {
        Integer nval;
        Stack<Pair> st;
        public GTPreorderIterator (Node root) {
            st = new Stack<>();
            st.push(new Pair(root,-1));
            next();
        }
        @Override
        public boolean hasNext() {
            if (nval == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Integer next() {
            Integer fr = nval;
            nval = null;
            while (st.size() > 0) {
                Pair top = st.peek();
                if(top.state == -1) {
                    nval = top.node.data;
                    top.state++;
                    break;
                } else if(top.node.children.size() == top.state) {
//                    nval = top.node.data;
                    st.pop();
//                    break;
                } else {
                    st.push(new Pair(top.node.children.get(top.state),-1));
                    top.state++;
                }
            }
            return fr;
        }
    }
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }
    /*
     *   If State -
     *           -1 -> Preorder , ++
     *           eq child size -> Postorder , pop
     *           0 to child size -1 -> child push , ++
     * */
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void IterativePreandPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node,-1));
        String pre = "";
        String post = "";
        while (st.size() > 0) {
            Pair top = st.peek();
            if(top.state == -1) {
                pre += top.node.data + " ";
                top.state++;
            } else if(top.node.children.size() == top.state) {
                post += top.node.data + " ";
                st.pop();
            } else {
                st.push(new Pair(top.node.children.get(top.state),-1));
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
//        IterativePreandPostOrder(root);
        GenericTree gt = new GenericTree(root);
        Iterator<Integer> iterator = gt.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
