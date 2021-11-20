import java.util.Scanner;

public class _39DiameterOfBinaryTreeAllMethods {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }


  // method 1 -> with height call
  private int height(TreeNode node) {
    if(node == null) return -1;

    int lh = height(node.left);
    int rh = height(node.right);

    return Math.max(lh, rh) + 1;
} 

private int diameter1(TreeNode node) {
    if(node == null) return 0;

    int ld = diameter1(node.left);
    int rd = diameter1(node.right);

    int lh = height(node.left);
    int rh = height(node.right);
    int rootDia = lh + rh + 2;
    
    // return max of all three possibility
    return Math.max(rootDia, Math.max(ld, rd));
}

// method 2 -> with return height amd static diameter variable, travel and change stretagy
static int diameter = 0;
private static int diamater2(TreeNode node) {
    if(node == null) return -1;

    int lh = diamater2(node.left);
    int rh = diamater2(node.right);

    diameter = Math.max(diameter, lh + rh + 2);

    return Math.max(lh, rh) + 1;
} 

// method 3 -> with wrapper class having diameter and height
private class DiaPair {
    int height;
    int diamter;

    DiaPair(int height, int diameter) {
        this.height = height;
        this.diamter = diameter;
    }

    DiaPair() {
        this.height = -1;
        this.diamter = 0;
    }
}

private DiaPair diameter3(TreeNode node) {
    if(node == null) return new DiaPair();

    DiaPair lpair = diameter3(node.left);
    DiaPair rpair = diameter3(node.right);

    DiaPair mpair = new DiaPair();
    mpair.height = Math.max(lpair.height, rpair.height) + 1;
    mpair.diamter = Math.max(lpair.height + rpair.height + 2, 
                    Math.max(lpair.diamter, rpair.diamter));

    return mpair;
}

public static int diameterOfBinaryTree(TreeNode root) {
    // int dia = diameter1(root);

    diameter = 0;
    diamater2(root);
    int dia = diameter;

    // int dia = diameter3(root).diamter;
    return dia;
}

  // input_Section=================================================

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
    System.out.println(diameterOfBinaryTree(root));
  }

  public static void main(String[] args) {
    solve();
  }
}