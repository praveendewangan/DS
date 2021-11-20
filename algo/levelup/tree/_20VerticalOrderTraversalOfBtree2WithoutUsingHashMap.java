import java.util.*;

public class _20VerticalOrderTraversalOfBtree2WithoutUsingHashMap {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static class Pair implements Comparable<Pair>{
        TreeNode node;
        int dir;
        Pair(TreeNode node,int dir) {
            this.node = node;
            this.dir = dir;
        }
        
        public int compareTo(Pair o) {
            return this.node.val - o.node.val;
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
    
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        lh = 0;
        rh = 0;
        int wd = width(root);

        for(int i = 0; i < wd; i++)
            res.add(new ArrayList<>());

        PriorityQueue<Pair> mq = new PriorityQueue<>();
        mq.add(new Pair(root, Math.abs(lh)));
        PriorityQueue<Pair> cq = new PriorityQueue<>();

        while(mq.size() > 0) {
            Pair rm = mq.remove();
            res.get(rm.dir).add(rm.node.val);
            
            if(rm.node.left != null) {
                cq.add(new Pair(rm.node.left,rm.dir-1));
            }
            if(rm.node.right != null) {
                cq.add(new Pair(rm.node.right,rm.dir+1));
            }
            
            if(mq.size() == 0) {
                mq = cq;
                cq = new PriorityQueue<>();
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}