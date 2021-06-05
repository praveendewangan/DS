import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _3PrePostInOrderTraversalIterativelyEfficient2 {
    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }

      public List<Integer> preorder(Node node){
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node cur = node;
        while(cur != null || !st.empty()) {
            // Travers left till leaf node
            while(cur != null) {
                list.add(cur.data);
                st.push(cur);
                cur = cur.left;
            }
            // last leaf node left side
            cur = st.pop();
            // move right leaf node
            cur = cur.right;
        }
        return list;
    }
    public List<Integer> inorder(Node node){
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node cur = node;
        while(cur != null || !st.empty()) {
            // Travers left till leaf node
            while(cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            // last leaf node left side
            cur = st.pop();
            list.add(cur.data);
            // move right leaf node
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> postorderTraversal(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return ans;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            ans.addFirst(cur.data);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            } 
        }
        return ans;
    }
}
