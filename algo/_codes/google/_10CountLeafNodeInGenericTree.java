public class _10CountLeafNodeInGenericTree {
    static class Node {
        int data;
        ArrayList<Node> children;
        int leafCount;

        public Node() {
            this.data = 0;
            this.children = new ArrayList<>();
        }
        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    public static Node construct(Integer[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(Integer data : arr){
            if(data != null) {
                Node nn = new Node(data);
                if(st.empty()) {
                    root = nn;
                } else {
                    st.peek().children.add(nn);
                }
                st.push(nn);
            } else {
                if(st.peek().children.size() == 0){
                    root.leafCount++;
                }
                st.pop();                
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] data = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = construct(data);
        System.out.println(root.count);
   }
}
