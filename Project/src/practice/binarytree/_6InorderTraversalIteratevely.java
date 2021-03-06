package practice.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class _6InorderTraversalIteratevely {
    // O(n),O(1)
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        inorder(root);
        System.out.println();
    }   
    private static void inorder(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        Node curr = root;
    
        while (!stack.empty() || curr != null)
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else {
                curr = stack.pop();
                System.out.print(curr.data + " ");
    
                curr = curr.right;
            }
        }
    }
}
