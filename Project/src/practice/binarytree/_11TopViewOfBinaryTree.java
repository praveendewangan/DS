package practice.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;

public class _11TopViewOfBinaryTree {
    // O(n),O(n)

    static ArrayList<Integer> topView(Node root)
    {
       ArrayList<Integer> list = new ArrayList<>();
       TreeMap<Integer,Integer> m = new TreeMap<>();
        class QueueObj {
            Node node;
            int hd;
            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new ArrayDeque<>();
        q.add(new QueueObj(root,0));
        while(q.size() > 0) {
            QueueObj temp = q.remove();
            int hd = temp.hd;
            
            if(!m.containsKey(hd)) {
                m.put(hd,temp.node.data);
            }
            if(temp.node.left != null) {
                q.add(new QueueObj(temp.node.left,hd-1));
            }
            if(temp.node.right != null) {
                q.add(new QueueObj(temp.node.right,hd+1));
            }
        }
        for(int val : m.values()) {
            list.add(val);
        }
        return list;
    }
}
