package practice.binarysearchtree;

import java.util.Stack;

public class _19PreorderToPostorder {
    // O(n),O(n)
    public static Node constructTree(int pre[], int size) {
        Node root = new Node(pre[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);

        for(int i=1;i<size;i++) {
            Node temp = null;
            while(!st.isEmpty() && pre[i] > st.peek().data) {
                temp = st.pop();
            }

            if(temp != null) {
                temp.right = new Node(pre[i]);
                st.push(temp.right);
            } else {
                temp = st.peek();
                temp.left = new Node(pre[i]);
                st.push(temp.left);
            }
        }
        return root;
    }
}
