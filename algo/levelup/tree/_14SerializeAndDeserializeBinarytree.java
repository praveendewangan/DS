import java.util.*;

public class _14SerializeAndDeserializeBinarytree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
     public static void serialize_(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null#");
            return;
        }

        sb.append(root.val + "#");
        serialize_(root.left, sb);
        serialize_(root.right, sb);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize_(root,sb);
        return sb.toString();
    }

    static class SPair {
        TreeNode node;
        int state;
        
        public SPair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        if(str.equals("null#")) return null;
        String[] data = str.split("#");
        int indx = 1;
        TreeNode root = new TreeNode(Integer.parseInt(data[0]));

        Stack<SPair> st = new Stack<>();
        st.push(new SPair(root, 0));

        while(indx < data.length) {
            if(st.peek().state == 0) {
                if(data[indx].equals("null") == true) {
                    st.peek().state++;
                    indx++;
                } else {
                    TreeNode nn = new TreeNode(Integer.parseInt(data[indx]));
                    indx++;
                    st.peek().state++;
                    st.peek().node.left = nn;
                    st.push(new SPair(nn, 0));
                }
            } else if(st.peek().state == 1) {
                if(data[indx].equals("null") == true) {
                    st.peek().state++;
                    indx++;
                } else {
                    TreeNode nn = new TreeNode(Integer.parseInt(data[indx]));
                    indx++;
                    st.peek().state++;
                    st.peek().node.right = nn;
                    st.push(new SPair(nn, 0));
                }
            } else {
                st.pop();
            }
        }
        return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}