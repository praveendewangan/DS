package practice.binarytree;

import java.util.HashSet;
import java.util.Set;

public class _24CheckDuplicateSubTreeInBT {
    // O(n),O(n)
    int res = 0;
    Set<String> set = new HashSet<>();
    int dupSub(Node root) {
        helper(root);
        return res; 
    }
    String helper(Node node) {
        if(node == null){
            return "$";
        }
        if(node.left == null && node.right == null) {
            return String.valueOf(node.data);
        }
        String ls = helper(node.left);
        String rs = helper(node.right);
        String str = String.valueOf(node.data)+ls+rs;
        if(set.contains(str)){
            res = 1;
        } else {
            set.add(str);
        }
        return str;
        
    }
}
