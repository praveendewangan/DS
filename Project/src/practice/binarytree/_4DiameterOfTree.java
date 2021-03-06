package practice.binarytree;

public class _4DiameterOfTree {
    // O(n^2),O(1)
    int diameter(Node root) {
        if(root == null) return 0;
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int h = height(root.left) + height(root.right) + 1;
        int dia = Math.max(h,Math.max(ld,rd));
        return dia;
    }
    int height(Node node) {
        if(node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh) + 1;
    }
}
