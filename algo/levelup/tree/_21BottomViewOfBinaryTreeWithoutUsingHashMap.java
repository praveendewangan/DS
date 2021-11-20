import java.util.*;

public class _21BottomViewOfBinaryTreeWithoutUsingHashMap {
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
        TreeNode node;
        int dir;
        Pair(TreeNode node,int dir) {
            this.node = node;
            this.dir = dir;
        }
    }
    private static int lh = 0;
    private static int rh = 0;

    public static int width(TreeNode root) {
        lh = 0;
        rh = 0;
        dfs(root,0);
       return rh-lh+1;
    }
    
    private static void dfs(TreeNode node,int val) {
        if(node == null) return;
        
        lh = Math.min(lh,val);
        rh = Math.max(rh,val);

        dfs(node.left,val-1);
        dfs(node.right,val+1);
    }
    public static ArrayList<Integer> BottomView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        lh = 0;
        rh = 0;
        int wd = width(root);

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < wd; i++)
            res.add(null);

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, Math.abs(lh)));

        while(qu.size() > 0) {
            // 1. get + remove
            Pair rem = qu.remove();
            // 2. work
            // if(res.get(rem.count) == null)
                res.set(rem.dir, rem.node.val);
            // 3. add children
            if(rem.node.left != null) {
                qu.add(new Pair(rem.node.left, rem.dir - 1));
            }
            if(rem.node.right != null) {
                qu.add(new Pair(rem.node.right, rem.dir + 1));
            }
        }
        return res;
    }

    // input_section=================================================

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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}