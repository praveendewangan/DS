package practice.binarytree;

import java.util.HashMap;
import java.util.Map;

public class _34DuplicateSubTree {
    // O(n*n),O(n)
    Map<String,Integer> m = null;
    boolean flag = false;
    public void printDup(Node root){
        m = new HashMap<>();
        inorder(root);
    }
    public String inorder(Node node) {
        if (node == null)
            return "";
      
        String str = "(";
        str += inorder(node.left);
        str += Integer.toString(node.data);
        str += inorder(node.right);
        str += ")";
      
        // Subtree already present (Note that we use
        // HashMap instead of HashSet
        // because we want to print multiple duplicates
        // only once, consider example of 4 in above
        // subtree, it should be printed only once.       
        if (m.get(str) != null && m.get(str)==1 )
            System.out.print( node.data + " ");
      
        if (m.containsKey(str))
            m.put(str, m.get(str) + 1);
        else
            m.put(str, 1);
         
        
        return str;
    }
}
