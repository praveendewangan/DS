package practice.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class _2ReverseLevelOrderTraversal {
    // O(n),O(n)
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(node == null) {
            return list;
        }
        Stack<Integer> st = new Stack<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0) {
            Node n = q.remove();
            st.push(n.data);
            if(n.right != null) {
                q.add(n.right);
            }
            if(n.left != null) {
                q.add(n.left);
            }
        }
        while(st.size() > 0) {
            list.add(st.pop());
        }
        return list;
    }
}
