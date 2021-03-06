package practice.binarytree;

import java.util.ArrayList;

public class _9LeftViewOfBinaryTree {
    // O(n),O(n)
    int max_level = 0; 
   void leftViewUtil(ArrayList<Integer> result, Node node, int level)
    {
        // base case
        if (node==null) return;
        
        // If this is the first node of its level 
        if (max_level < level)
        {
            result.add(node.data);
            max_level = level;
        }
        
        // Recur for left and right subtrees 
        leftViewUtil(result, node.left, level+1);
        leftViewUtil(result, node.right, level+1);
    }
    
    // Function to get the left view
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
		leftViewUtil(result, root, 1);
		return result;
    }
}
