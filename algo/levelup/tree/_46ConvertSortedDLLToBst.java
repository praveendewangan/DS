import java.util.*;

class _46ConvertSortedDLLToBst {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }
  
  private static Node getMid(Node node) {
      Node slow = node;
      Node fast = node.right;
      while(fast != null && fast.right != null) {
          slow = slow.right;
          fast = fast.right.right;
      }
      return slow;
  }

  // left : prev, right : next
  public static Node SortedDLLToBST(Node head) {
      if(head == null) return null;
      Node mid = getMid(head);
      if(mid.left != null) {
          mid.left.right = null;
          mid.left = null;
      }
      Node head2 = mid.right;
      if(mid.right != null) {
          mid.right.left = null;
          mid.right = null;
      }
      if(mid != head) {
          mid.left = SortedDLLToBST(head);
      }
      mid.right = SortedDLLToBST(head2);
    return mid;
  }

  // Input_code===================================================

  public static void display(Node node) {
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

  public static Node makeList(int n) {
    Node dummy = new Node(-1);
    Node prev = dummy;
    while (n-- > 0) {
      Node node = new Node(scn.nextInt());
      prev.right = node;
      node.left = prev;
      prev = prev.right;
    }

    Node head = dummy.right;
    head.left = dummy.right = null;

    return head;
  }

  public static void main(String[] args) {
    Node head = makeList(scn.nextInt());

    head = SortedDLLToBST(head);
    display(head);
  }

}