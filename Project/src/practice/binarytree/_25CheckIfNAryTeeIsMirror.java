package practice.binarytree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class _25CheckIfNAryTeeIsMirror {
    // O(n),O(n)
    static class Node {
        int data;
        List<Node> children;
    }
    static Queue<Integer> q = null;
    static Stack<Integer> st = null;
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t != 0) {
		    q = new ArrayDeque<>();
            st = new Stack<>();
            while(q.size() != 0) {
                if(q.remove() != st.pop()){
                    System.out.print(false);
                }
            }
		    t--;
		}
	}
	public static void pushQ(Node node) {
	    if(node == null) return;
	    for(int i=0;i<node.children.size();i++){
	        pushQ(node.children.get(i));
	    }
	    q.add(node.data);
	}
	public static void pushSt(Node node) {
	    if(node == null) return;
	    st.push(node.data);
	    for(int i=0;i<node.children.size();i++){
	        pushSt(node.children.get(i));
	    }
	}
}
