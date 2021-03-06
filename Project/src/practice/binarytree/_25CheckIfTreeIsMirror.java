package practice.binarytree;

public class _25CheckIfTreeIsMirror {
    boolean isMirror(Node a, Node b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        return a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
