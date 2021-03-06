package practice.binarytree;

import java.util.Vector;

public class _30PrintKSumPathsBinaryTree {
    // O(n*h*h),O(h)
    public static void main(String[] args) {
        Node root = new Node(1);  
        root.left = new Node(3);  
        root.left.left = new Node(2);  
        root.left.right = new Node(1);  
        root.left.right.left = new Node(1);  
        root.right = new Node(-1);  
        root.right.left = new Node(4);  
        root.right.left.left = new Node(1);  
        root.right.left.right = new Node(2);  
        root.right.right = new Node(5);  
        root.right.right.right = new Node(2);
        int k = 5;
        printKSumpath(root,k,new Vector<Integer>());
    }

    public static void printKSumpath(Node node,int k,Vector<Integer> path) {
        if(node == null) return;

        path.add(node.data);
        printKSumpath(node.left, k, path);
        printKSumpath(node.right, k, path);

        int sum = 0;
        for(int i=path.size()-1;i >= 0;i--){
            sum += path.get(i);
            if(sum == k) {
                for (int j = i; j < path.size(); j++) {
                    System.out.print(path.get(j) + " ");
                }
                System.out.println();
            }
        }
        path.remove(path.size()-1);
    }
}
