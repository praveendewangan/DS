package practice.binarytree;

public class _35CheckIfTreeIsIsomorphic {
    // O(min(M,N)),O(min(H1,H2))
    boolean isIsomorphic(Node a, Node b)  
    { 
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        return a.data == b.data && ((isIsomorphic(a.left,b.right)
            && isIsomorphic(a.right,b.left)) || (isIsomorphic(a.left,b.left)
            && isIsomorphic(a.right,b.right)));
    }
}
