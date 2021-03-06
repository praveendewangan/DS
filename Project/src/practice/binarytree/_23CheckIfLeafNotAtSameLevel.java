package practice.binarytree;

public class _23CheckIfLeafNotAtSameLevel {
    // O(n),(h)
    int leafLevel = 0;
    boolean check(Node root)
    {
        return helper(root,0);
    }
    
    boolean helper(Node node,int level) {
        if(node == null) {
            return true;
        }
        if(node.left == null && node.right == null){
            if(leafLevel != 0 && level != leafLevel){
                return false;   
            }
            leafLevel = level;
            return true;
        }
        return helper(node.left,level+1) && helper(node.right,level+1);
    }
}
