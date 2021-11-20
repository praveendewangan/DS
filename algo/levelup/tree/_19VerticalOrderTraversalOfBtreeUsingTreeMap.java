import java.util.*;

public class _19VerticalOrderTraversalOfBtreeUsingTreeMap {
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
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        TreeMap<Integer,ArrayList<Integer>> treeMap = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int lvl = 0;
        while(q.size() > 0) {
            int size = q.size();
            while(size-- > 0) {
                Pair rm = q.remove();
                int key = rm.dir;
                TreeNode node = rm.node;
                if(!treeMap.containsKey(key)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    treeMap.put(key,list);
                } else {
                    treeMap.get(key).add(node.val);
                }
                if(rm.node.left != null) {
                    q.add(new Pair(rm.node.left,key-1));
                }
                
                if(rm.node.right != null) {
                    q.add(new Pair(rm.node.right,key+1));
                }
                
            }
        }
        
        for(int key : treeMap.keySet()) {
            res.add(treeMap.get(key));
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