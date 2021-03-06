package practice.binarytree;

import java.util.ArrayList;

public class _10RightViewOfBinaryTree {
    // O(n),O(n)
    int max_level = 0;
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        rightViewOfTree(list,node,1);
        return list;
    }
    void rightViewOfTree(ArrayList<Integer> list,Node node,int level) {
        if(node == null) {
            return;
        }
        if(max_level < level) {
            list.add(node.data);
            max_level = level;
        }
        rightViewOfTree(list,node.right,level+1);
        rightViewOfTree(list,node.left,level+1);
    }
}
