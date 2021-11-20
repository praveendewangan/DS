import java.util.Scanner;

public class _9HouseRobber3 {
    // LC337
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
        int withRob;
        int withoutRob;
        
        public Pair(int withRob,int withoutRob) {
            this.withRob = withRob;
            this.withoutRob = withoutRob;
        }
    }
    public static int HouseRobber(TreeNode root) {
        Pair p = helper(root);
        return Math.max(p.withRob,p.withoutRob);
    }
    
    private static Pair helper(TreeNode node) {
        if(node == null) return new Pair(0,0);
        
        Pair left = helper(node.left);
        Pair right = helper(node.right);
        
        int a = left.withRob;
        int a_ = right.withRob;
        int b = left.withoutRob;
        int b_ = right.withoutRob;
        int c = node.val;
        // Robbery -> b + b_ + c
        // Without robbery -> max(a,b) + max(a_,b_)
        int withRob = b + b_ + c;
        int withoutRob = Math.max(a,b) + Math.max(a_,b_);
        return new Pair(withRob,withoutRob);
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}