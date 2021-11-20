import java.util.*;

public class _22TopViewOfBinaryTree {
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
    public static ArrayList<Integer> TopView(TreeNode root) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(q.size() > 0) {
            Pair rm = q.remove();
            int key = rm.dir;
            if(!map.containsKey(key)){
                map.put(key,rm.node.val);
            }
            
            if(rm.node.left != null) {
                q.add(new Pair(rm.node.left,key-1));
            }
            
            if(rm.node.right != null) {
                q.add(new Pair(rm.node.right,key+1));
            }
        }
        for(int key : map.keySet()) {
            res.add(map.get(key));
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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}