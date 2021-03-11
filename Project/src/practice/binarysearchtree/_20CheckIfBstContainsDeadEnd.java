package practice.binarysearchtree;

public class _20CheckIfBstContainsDeadEnd {
    // O(n),O(1)
    public static boolean isDeadEnd(Node root)
    {
        return helper(root,1,Integer.MAX_VALUE);
    }
    public static boolean helper(Node node,int min, int max) {
        if(node == null) {
             return false;
        }
        if(min == max) {
            return true;
        }
        return (helper(node.left,min,node.data-1) || helper(node.right,node.data+1,max));
    }
}
