import java.util.*;

public class _13ConstructBSTFromLevelOrder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    static class Pair {
        TreeNode parent;
        int left;
        int right;
        
        Pair() {
            this.parent = null;
            this.left = Integer.MIN_VALUE;
            this.right = Integer.MAX_VALUE;
        }
        Pair(TreeNode parent,int left,int right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] levelOrder) {
        int n = levelOrder.length;
        Queue<Pair> q = new LinkedList<>();
        TreeNode root = null;
        q.add(new Pair());
        int idx = 0;
        
        while(q.size() != 0 && idx < n) {
            Pair rm = q.remove();
            int ele = levelOrder[idx];
            if(ele < rm.left || ele > rm.right) continue;
            
            TreeNode node = new TreeNode(ele);
            idx++;
            if(rm.parent == null) {
                root = node;
            } else {
                TreeNode parent = rm.parent;
                
                if(ele < parent.val) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            
            q.add(new Pair(node,rm.left,ele));
            q.add(new Pair(node,ele,rm.right));
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

    public static void solve() {
        int n = scn.nextInt();
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}