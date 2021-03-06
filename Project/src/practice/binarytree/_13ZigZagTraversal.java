package practice.binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class _13ZigZagTraversal {
    // O(n),O(n)
        // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    Stack<Node> ms = new Stack<>();
	    Stack<Node> cs = new Stack<>();
	    boolean leftToRight = true;
	    ms.push(root);
	    while(ms.size() > 0) {
	        Node node = ms.pop();
	        list.add(node.data);
	        if(leftToRight) {
	            if(node.left != null) {
	                cs.push(node.left);
	            }
	            if(node.right != null) {
	                cs.push(node.right);
	            }
	        } else {
	            if(node.right != null) {
	                cs.push(node.right);
	            }
	            if(node.left != null) {
	                cs.push(node.left);
	            }
	        }
	        if(ms.size() == 0) {
	            leftToRight = !leftToRight;
	            ms = cs;
	            cs = new Stack<>();
	        }
	    }
	    return list;
	}
}
