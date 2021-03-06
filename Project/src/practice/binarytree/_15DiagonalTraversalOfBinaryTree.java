package practice.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class _15DiagonalTraversalOfBinaryTree {
    // O(n),O(n)
    public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<Integer> list = new ArrayList<>();
           Queue<Node> q = new ArrayDeque<>();
           q.add(root);
           while(q.size() > 0) {
               Node cur = q.remove();
               while(cur != null) {
               if(cur.left != null) q.add(cur.left);
               list.add(cur.data);
               cur = cur.right;
               }
           }
           return list;
      }
}
