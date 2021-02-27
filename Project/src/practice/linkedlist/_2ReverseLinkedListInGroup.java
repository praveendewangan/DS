package practice.linkedlist;

import java.util.Stack;

public class _2ReverseLinkedListInGroup {
    // O(n),O(k)
    public static class Node {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    public static Node reverse(Node node, int k)
    {
        Node prev = null;
        Node cur = node;
        Stack<Node> st = new Stack<>();
        while(cur != null){
            int count = 0;
            while(cur != null && count < k){
                st.push(cur);
                cur = cur.next;
                count++;
            }
            
            while(st.size() > 0) {
                if(prev == null) {
                    prev = st.peek();
                    node = prev;
                } else {
                    prev.next = st.peek();
                    prev = prev.next;
                }
                    st.pop();
            }
        }
        prev.next = null;
        return node;
    }
}
