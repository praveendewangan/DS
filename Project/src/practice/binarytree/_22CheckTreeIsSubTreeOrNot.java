package practice.binarytree;

public class _22CheckTreeIsSubTreeOrNot {
    // O(n),O(1)
    boolean flag = true;
	boolean isSumTree(Node root)
	{
            helper(root);
            return flag;
	}
	public int helper(Node node) {
	    if(node == null) {
	        return 0;
	    }
	    if(node.left == null && node.right == null) {
	        return node.data;
	    }
	    int ld = helper(node.left);
	    int rd = helper(node.right);
	    if(ld + rd != node.data) {
	        flag = false;
	    }
	    return ld + rd + node.data;
	}
}
