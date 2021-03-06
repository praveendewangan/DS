package practice.binarytree;

public class _4DiameterOfTree2 {
    // O(n),O(1)
    public static class Height {
        int h;
    }
    int diameter(Node root) {
        return diameter(root,new Height());
    }
    int diameter(Node root,Height height) {
        if(root == null) return 0;
        Height lh = new Height();
        Height rh = new Height();
        int ld = diameter(root.left,lh);
        int rd = diameter(root.right,rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        int dia = Math.max(lh.h+rh.h+1,Math.max(ld,rd));
        return dia;
    }
}
