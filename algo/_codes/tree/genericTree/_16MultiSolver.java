public class _16MultiSolver {
    static class Node {
        int data;
        ArrayList<Node> children;

        public Node() {
            this.data = 0;
            this.children = new ArrayList<>();
        }
        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int height = 0;
    static int size = 0;

    private static void multisolver1(Node node,int ht) {
        if(node.data < min) {
            min = node.data;
        }
        if(node.data > max) {
            max = node.data;
        }
        size++;
        height = Math.max(height,ht);
        for(Node child : node.children){
            multisolver1(child, ht+1);
        }
    }

    static class Multisolver {
        int min;
        int max;
        int height;
        int size;
        public Multisolver(){}
        public Multisolver(int min,int max,int height,int size){
            this.min = min;
            this.max = max;
            this.height = height;
            this.size = size;
        }
    }

    public static Multisolver multisolver2(Node node) {
        Multisolver mres = new Multisolver(node.data,node.data,-1,1);
        for(Node child : node.children) {
            Multisolver rres = multisolver2(child);
            mres.min = Math.min(mmres.min, rres.min);
            mres.max = Math.min(mmres.max, rres.max);
            mres.height = Math.Max(mmres.height, rres.height);
            mres.size += rres.size;
        }
        mmres.height += 1;
        return mmres;
    }
}
