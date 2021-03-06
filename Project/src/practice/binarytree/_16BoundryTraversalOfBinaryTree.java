package practice.binarytree;

import java.util.ArrayList;

public class _16BoundryTraversalOfBinaryTree {
    // O(n),O(n)
    ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    list.add(node.data);
	    printBoundryLeft(node.left,list);
	    printLeaves(node.left,list);
	    printLeaves(node.right,list);
	    printBoundryRight(node.right,list);
	    return list;
	}
	void printBoundryLeft(Node node,ArrayList <Integer> list) {
	    if(node == null) return;
	    if(node.left != null) {
	        list.add(node.data);
	        printBoundryLeft(node.left,list);
	    } else if(node.right != null) {
	        list.add(node.data);
	        printBoundryLeft(node.right,list);
	    }
	}
	
	void printLeaves(Node node,ArrayList <Integer> list) {
	    if(node == null) return;
	        printLeaves(node.left,list);
	    if(node.left == null && node.right == null) {
	        list.add(node.data);
	    }
        printLeaves(node.right,list);
	}
	void printBoundryRight(Node node,ArrayList <Integer> list) {
	    if(node == null) return;
	    if(node.right != null) {
	        printBoundryRight(node.right,list);
	        list.add(node.data);
	    } else if(node.left != null) {
	        printBoundryRight(node.left,list);
	        list.add(node.data);
	    }
	}
}
