
import java.util.*;

public class _30BSTIterator2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
        this.val = val;
    }
    }

    public static class BSTIterator {
    private Stack<TreeNode> st;

    private void addAllLeft(TreeNode node) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        addAllLeft(root);
    }
    
    public int next() {
        TreeNode rem = st.pop();
        if(rem.right != null) {
            addAllLeft(rem.right);
        }
        return rem.val;
    }
    
    public boolean hasNext() {
        return st.size() != 0;
    }

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

    public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
        return null;

    int mid = (si + ei) / 2;
    TreeNode node = new TreeNode(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
    }

    public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
        in[i] = scn.nextInt();

    TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
    BSTIterator itr = new BSTIterator(root);
    while (itr.hasNext()) {
        System.out.println(itr.next());
    }
    }

    public static void main(String[] args) {
    solve();
    }
}