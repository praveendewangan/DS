import java.util.*;

public class _19VerticalOrderTraversalOfBtreeUsingHashMap {
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
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, 0));
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int lh = 0; // left horizontal
        int rh = 0; // right horizontal 
        while(qu.size() > 0) {
            // 1. get + remove
            Pair rem = qu.remove();
            // 2. work
            if(map.containsKey(rem.dir)) {
                map.get(rem.dir).add(rem.node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(rem.node.val);
                map.put(rem.dir, list);
            }
            if(rem.dir < lh) {
                lh = rem.dir;
            } else if(rh < rem.dir) {
                rh = rem.dir;
            }
            // 3. add children
            if(rem.node.left != null) {
                qu.add(new Pair(rem.node.left, rem.dir - 1));
            }
            if(rem.node.right != null) {
                qu.add(new Pair(rem.node.right, rem.dir + 1));
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = lh; i <= rh; i++) {
            res.add(map.get(i));
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