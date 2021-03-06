package practice.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class _1LevelOrderTraversal {
    // O(n),O(n)
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(node == null) {
            return list;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() != 0) {
            
            Node n = q.remove();
            list.add(n.data);
            if(n.left != null) {
                q.add(n.left);
            }
            if(n.right != null) {
                q.add(n.right);
            }
        }
        return list;
    }
}
