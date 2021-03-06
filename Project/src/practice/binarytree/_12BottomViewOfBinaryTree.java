package practice.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

public class _12BottomViewOfBinaryTree {
    // O(n),O(n)
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer,Integer> m = new TreeMap<>();
        Queue<Node> q = new ArrayDeque<>();
        root.hd = 0;
        q.add(root);
        while(q.size() > 0) {
            Node node = q.remove();
            m.put(node.hd,node.data);
            
            if(node.left != null) {
                node.left.hd = node.hd - 1;
                q.add(node.left);
            }
            
            if(node.right != null) {
                node.right.hd = node.hd + 1;
                q.add(node.right);
            }
        }
        for(int val : m.values()) {
            list.add(val);
        }
        return list;
    }
}
