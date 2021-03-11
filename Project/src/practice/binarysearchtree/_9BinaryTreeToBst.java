package practice.binarysearchtree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class _9BinaryTreeToBst {
    // O(nlogn),O(n)
    Node binaryTreeToBST(Node node)
    {
       if(node == null){
           return null;
       }
       Set<Integer> set = new TreeSet<>();
    //   List<Integer> list = new ArrayList<>();
       getInorderList(node,set);
    //   Collections.sort(list);
        Iterator<Integer> it = set.iterator();
       createBst(node,it);
       return node;
    }
    
    void getInorderList(Node node,Set<Integer> list) {
        if(node == null) {
            return;
        }
        getInorderList(node.left,list);
        list.add(node.data);
        getInorderList(node.right,list);
        
    }
    void createBst(Node node,Iterator<Integer> it) {
        if(node == null){
            return;
        }
        createBst(node.left,it);
        node.data = it.next();
        createBst(node.right,it);
    }
}
