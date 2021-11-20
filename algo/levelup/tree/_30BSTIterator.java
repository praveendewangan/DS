class _30BSTIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    class Pair {
        TreeNode node;
        int state;
        
        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    private int itr_val = -1;
    
    private Stack<Pair> st;
    
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        st.push(new Pair(root, 0));
        next();
    }
    
    public int next() {
        int val2 = itr_val;
        itr_val = -1;
        while(st.size() > 0) {
            Pair top = st.peek();
            if(top.state == 0) {
                if(top.node.left != null) {
                    st.push(new Pair(top.node.left, 0));
                }
                top.state++;
            } else if(top.state == 1) {
                if(top.node.right != null) {
                    st.push(new Pair(top.node.right, 0));
                }
                top.state++;
                itr_val = top.node.val;
                break;
            } else {
                st.pop();
            }
        }
        return val2;
    }
    
    public boolean hasNext() {
        if(itr_val == -1) return false;
        else return true;
    }
}
