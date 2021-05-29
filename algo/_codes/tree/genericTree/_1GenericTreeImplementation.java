import java.util.*;
public class _1GenericTreeImplementation {
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
                st.pop();                
            }
        }
        return root;
    }
    private static int size(Node root) {
        int size = 0;
        for(Node child : root.children) {
            size += size(child);
        }
        return size + 1;
    }
    private static int max(Node root) {
        int max = root.data;
        for(Node child : root.children){
            int data = max(child);
            if(data > max){
                max = data;
            }
        }
        return max;
    }
    // First Approch
    private static int height(Node root) {
        int ht = 0;
        for(Node child : root.children){
            int data = height(child);
            ht = Math.max(data,ht);
        }
        if(root.children.size() > 0) {
            ht += 1;
        }
        return ht;
    }
    // Second Approch
    private static int height1(Node root) {
        int ht = -1;
        for(Node child : root.children){
            ht = Math.max(ht,height1(child));
        }
        return ht + 1;
    }
    
    private static int heightNode(Node root) {
        int ht = 1;
        for(Node child : root.children){
            int data = heightNode(child);
            ht = Math.max(data,ht);
        }
        return ht;
    }
    
    private static int min(Node root) {
        int min = root.data;
        for(Node child : root.children){
            int data = min(child);
            if(data < min){
                min = data;
            }
        }
        return min;
    }
    private static void display(Node root) {
        String str = "[" + root.data + "] ->";
        for(Node child : root.children) {
            str += child.data +",";
        }
        System.out.println(str+".");
        for(Node child : root.children) {
            display(child);
        }
    }
    public static void main(String[] args) {
        Integer[] data = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = construct(data);
        display(root);
        System.out.println(size(root));
        System.out.println(max(root));
        System.out.println(min(root));
        System.out.println(height(root));
    }
}
