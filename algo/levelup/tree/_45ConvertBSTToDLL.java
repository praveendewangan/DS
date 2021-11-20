import java.util.Scanner;

public class _45ConvertBSTToDLL {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }

  static Node prev = null;
    
    private static void bToDLL_(Node node) {
        if(node == null) return;
        
        bToDLL_(node.left);
        // in area
        prev.right = node;
        node.left = prev;
        prev = node;
        bToDLL_(node.right);
    }

    public static Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;
        bToDLL_(root);
        
        Node head = dummy.right;
        head.left = prev;
        prev.right = head;
        
        return head;
    }

  // input_section=================================================

  public static void display(Node node) {
    Node head = node;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.right;
      if (node == head)
        break;
    }

  }

  public static Node constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    Node node = new Node(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static Node constructFromInOrder(int[] inOrder) {
    int n = inOrder.length;
    return constructFromInOrder_(inOrder, 0, n - 1);
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    Node root = constructFromInOrder(in);
    root = bToDLL(root);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}